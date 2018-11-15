package sso.service.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cloud.sso.api.DataExchange;
import cloud.sso.serial.DataExchangeImpl;

@Configuration
public class CustomBeanConfig {
	
	@Bean
	public DataExchange dataExchange() {
		return new DataExchangeImpl();
	}

}
