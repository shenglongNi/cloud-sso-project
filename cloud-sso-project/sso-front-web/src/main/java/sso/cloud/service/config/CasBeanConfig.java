package sso.cloud.service.config;

import org.jasig.cas.CentralAuthenticationService;
import org.jasig.cas.CentralAuthenticationServiceImpl;
import org.jasig.cas.authentication.AuthenticationManager;
import org.jasig.cas.ticket.registry.DefaultTicketRegistry;
import org.jasig.cas.ticket.registry.TicketRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CasBeanConfig {

	@Bean
	public CentralAuthenticationService getCentralAuthenticationService(TicketRegistry ticketRegistry) {
//		CentralAuthenticationService authenticationService = new CentralAuthenticationServiceImpl(
//				ticketRegistry, 
//				authenticationManager, 
//				ticketGrantingTicketUniqueTicketIdGenerator, 
//				uniqueTicketIdGeneratorsForService, 
//				ticketGrantingTicketExpirationPolicy, 
//				serviceTicketExpirationPolicy, 
//				servicesManager, 
//				logoutManager);
		
		return null ;
	}
	
	@Bean
	public TicketRegistry getTicketRegistry() {
		
		return new DefaultTicketRegistry();
	}
	
	public AuthenticationManager getAuthenticationManager() {
		return null;
	}
	
}
