package sso.cloud.service.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean encodingFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new CharacterEncodingFilter());
		filterRegistrationBean.addInitParameter("encoding", "utf-8");
		filterRegistrationBean.addUrlPatterns("/**");
		filterRegistrationBean.setOrder(1);
		
		return filterRegistrationBean;
	}
	
}
