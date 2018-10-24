package sso.cloud.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SingleSignOnAction {
	
	
	@GetMapping(path="/login")
	public String login(HttpServletRequest request,
			HttpServletResponse response,
			@CookieValue String ticketGrantingTiket) {

		
		return null;
	}
	
	
}
