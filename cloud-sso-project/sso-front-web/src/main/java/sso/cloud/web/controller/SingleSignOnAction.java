package sso.cloud.web.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.CentralAuthenticationService;
import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.RootCasException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.principal.Response;
import org.jasig.cas.authentication.principal.Service;
import org.jasig.cas.authentication.principal.WebApplicationService;
import org.jasig.cas.ticket.ServiceTicket;
import org.jasig.cas.ticket.TicketGrantingTicket;
import org.jasig.cas.web.support.ArgumentExtractor;
import org.jasig.cas.web.support.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SingleSignOnAction {
	
	
	private static final String DEFAULT_LOGIN_SUCCESS_PAGE = "default_login_success";

	private static Logger logger = LoggerFactory.getLogger(SingleSignOnAction.class);
	
	private static final String LOGIN_PAGE = "index";
	
	@Autowired
	private List<ArgumentExtractor> argumentExtractor;
	
	@Autowired
	private CentralAuthenticationService centralAuthenticationService;

	@RequestMapping("/login")
	public String login(HttpServletRequest request,
			HttpServletResponse response,
			@CookieValue(value="CASTGC", required=false) String ticketGrantingTiket) {

		HttpSession session = request.getSession();
		logger.info("用户登录，当前sessionId:{}", session.getId());
		
		Service service = WebUtils.getService(argumentExtractor, request);
		
		ServiceTicket serviceTicket = null;
		Response casResponse = null;
		if(StringUtils.isNotBlank(ticketGrantingTiket)) {
			if(service != null) {
				try {
					serviceTicket = centralAuthenticationService.grantServiceTicket(ticketGrantingTiket, service);
					logger.info("service ticket 【{}】 生成成功!", service.getId());
					casResponse = ((WebApplicationService) service).getResponse(serviceTicket.getId());
				} catch (RootCasException e) {
					logger.error("service ticket 生成失败");
					return LOGIN_PAGE;
				}
				
				return casResponse.getUrl();
			}
		} else if(service != null){
			session.setAttribute("service", service);
			
		}
		
		Cookie cookie = new Cookie("CASTGC", null);
		cookie.setPath("/idm");
		response.addCookie(cookie);
		
		return LOGIN_PAGE;
	}
	
	
	@RequestMapping("/auth")
	public String loginSubmint(HttpServletRequest request, HttpServletResponse response, String username,
			String password) {
		username = "nsl";
		password = "111111";
		HttpSession session = request.getSession();
		logger.info("用户登录认证开始, 当前sessionId:{}", session.getId());
		Credential credential = new UsernamePasswordCredential(username, password);
		
		Service service = (Service) session.getAttribute("service");
		
		TicketGrantingTicket ticketGrantingTicket = null;
		ServiceTicket serviceTicket = null;
		Response casResponse = null;
		try {
			ticketGrantingTicket = centralAuthenticationService.createTicketGrantingTicket(credential);
			logger.info("用户[{}] TGT生成成功：{}", username, ticketGrantingTicket.getId());
			Cookie cookie = new Cookie("CASTGC", ticketGrantingTicket.getId());
			cookie.setPath("/idm");
			response.addCookie(cookie);
			
			serviceTicket = centralAuthenticationService.grantServiceTicket(ticketGrantingTicket.getId(), service);
			logger.info("用户[{}] ST生成成功：{}", username, serviceTicket.getId());
			if(service != null) {
				casResponse = ((WebApplicationService) service).getResponse(serviceTicket.getId());
				logger.info("[{}] 用户登录认证成功， 重定向目标地址：{}", username, casResponse.getUrl());
				return "redirect:" + casResponse.getUrl();
			}
			
			
		} catch (Exception e) {
			logger.error("用户[{}] 认证失败！", username, e);
			return LOGIN_PAGE;
		}
		
		return DEFAULT_LOGIN_SUCCESS_PAGE;
	}
	
}
