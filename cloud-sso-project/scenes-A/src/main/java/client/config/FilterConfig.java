package client.config;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.validation.Cas10TicketValidationFilter;
import org.jasig.cas.client.validation.Cas10TicketValidator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

	private static final String LOGIN_URL = "http://localhost:8080/idm/login.html";
	
	private static final String SERVER_NAME = "http://localhost:2001/sceneA";
	
	@Bean
	public FilterRegistrationBean singleSignOutFilter() {
		FilterRegistrationBean filterRegistrationBean = new  FilterRegistrationBean();
		filterRegistrationBean.setFilter(new SingleSignOutFilter());
		filterRegistrationBean.addInitParameter("casServerUrlPrefix", "http://localhost:8080/idm/");
		filterRegistrationBean.addInitParameter("serverName", "http://localhost:2001/sceneA/");
		filterRegistrationBean.setOrder(3);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
	
	@Bean
	public AuthenticationFilter authenticationFilter() {
		FilterRegistrationBean filterRegistrationBean = new  FilterRegistrationBean();
		AuthenticationFilter authenticationFilter = new AuthenticationFilter();
		filterRegistrationBean.setFilter(authenticationFilter);
		authenticationFilter.setCasServerLoginUrl(LOGIN_URL);
		authenticationFilter.setServerName(SERVER_NAME);
		filterRegistrationBean.addInitParameter("service", "http://localhost:2001/sceneA/");
		filterRegistrationBean.addInitParameter("serverName", "http://localhost:2001/sceneA/");
		filterRegistrationBean.addInitParameter("casServerUrlPrefix", "http://localhost:8080/idm/");
		filterRegistrationBean.setOrder(4);
		filterRegistrationBean.addUrlPatterns("/*");
		return authenticationFilter;
	}
	
	@Bean
	public Cas10TicketValidationFilter cas10TicketValidationFilter(Cas10TicketValidator validator) {
		FilterRegistrationBean filterRegistrationBean = new  FilterRegistrationBean();
		Cas10TicketValidationFilter cas10TicketValidationFilter = new Cas10TicketValidationFilter();
		cas10TicketValidationFilter.setService("http://localhost:2001/sceneA/");
		cas10TicketValidationFilter.setTicketValidator(validator);
		filterRegistrationBean.addInitParameter("casServerUrlPrefix", "http://localhost:8080/idm/");
		filterRegistrationBean.addInitParameter("serverName", "http://localhost:2001/sceneA/");
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.setFilter(cas10TicketValidationFilter);
		filterRegistrationBean.setOrder(5);
		return cas10TicketValidationFilter;
	}
	
	@Bean
	public Cas10TicketValidator cas10TicketValidator() {
		Cas10TicketValidator validator = new Cas10TicketValidator("http://localhost:8080/idm/");
		return validator;
	
	}
	}