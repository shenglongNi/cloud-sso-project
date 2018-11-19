package client.config;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.validation.Cas10TicketValidationFilter;
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
		filterRegistrationBean.setOrder(3);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
	
	@Bean
	public AuthenticationFilter authenticationFilter() {
		FilterRegistrationBean filterRegistrationBean = new  FilterRegistrationBean();
		AuthenticationFilter authenticationFilter = new AuthenticationFilter();
		authenticationFilter.setCasServerLoginUrl(LOGIN_URL);
		authenticationFilter.setServerName(SERVER_NAME);
		filterRegistrationBean.setFilter(authenticationFilter);
		filterRegistrationBean.setOrder(4);
		filterRegistrationBean.addUrlPatterns("/*");
		return authenticationFilter;
	}
	
	@Bean
	public Cas10TicketValidationFilter cas10TicketValidationFilter() {
		FilterRegistrationBean filterRegistrationBean = new  FilterRegistrationBean();
		Cas10TicketValidationFilter cas10TicketValidationFilter = new Cas10TicketValidationFilter();
//		cas10TicketValidationFilter.set
		
		
		return cas10TicketValidationFilter;
	}
	
}
