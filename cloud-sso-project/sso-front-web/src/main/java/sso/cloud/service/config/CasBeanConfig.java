package sso.cloud.service.config;

import java.util.concurrent.TimeUnit;

import org.jasig.cas.CentralAuthenticationService;
import org.jasig.cas.authentication.AuthenticationHandler;
import org.jasig.cas.authentication.AuthenticationManager;
import org.jasig.cas.authentication.PolicyBasedAuthenticationManager;
import org.jasig.cas.services.DefaultRegisteredServiceAccessStrategy;
import org.jasig.cas.services.InMemoryServiceRegistryDaoImpl;
import org.jasig.cas.services.RegexRegisteredService;
import org.jasig.cas.services.RegisteredService;
import org.jasig.cas.services.ServiceRegistryDao;
import org.jasig.cas.ticket.registry.DefaultTicketRegistry;
import org.jasig.cas.ticket.registry.TicketRegistry;
import org.jasig.cas.ticket.support.HardTimeoutExpirationPolicy;
import org.jasig.cas.ticket.support.TicketGrantingTicketExpirationPolicy;
import org.jasig.cas.util.DefaultUniqueTicketIdGenerator;
import org.jasig.cas.util.UniqueTicketIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import sso.cloud.authentication.handler.MobileAuthenticationHandler;

@Configuration
public class CasBeanConfig {

	private Logger logger = LoggerFactory.getLogger(MobileAuthenticationHandler.class);
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
	
	@Bean
	public AuthenticationManager getAuthenticationManager(AuthenticationHandler mobileAuthenticationHandler) {
		AuthenticationManager authManager = new PolicyBasedAuthenticationManager(mobileAuthenticationHandler);
		return authManager;
	}
	
	@Bean
	public UniqueTicketIdGenerator ticketIdGenerator() {
		logger.info("====init successful");
		return new DefaultUniqueTicketIdGenerator(); 
	}
	
	//maxTimeToLive 8h ,timeToKill 2h
	@Bean
	public TicketGrantingTicketExpirationPolicy ticketGrantingTicketExpirationPolicy() {
		return new TicketGrantingTicketExpirationPolicy(8 * 60 * 60, 2 * 60 * 60, TimeUnit.SECONDS);
	}
	
	@Bean
	public HardTimeoutExpirationPolicy serviceTicketExpirationPolicy() {
		return new HardTimeoutExpirationPolicy(5 * 60, TimeUnit.SECONDS);
	}
	
	@Bean
	public ServiceRegistryDao serviceRegistryDao() {
		InMemoryServiceRegistryDaoImpl serviceRegistryDao = new InMemoryServiceRegistryDaoImpl();
		RegexRegisteredService registeredService = new  RegexRegisteredService();
		registeredService.setServiceId("localhost");
		
		DefaultRegisteredServiceAccessStrategy accessStrategy = new DefaultRegisteredServiceAccessStrategy();
		accessStrategy.setEnabled(true);
		accessStrategy.setSsoEnabled(true);
		registeredService.setAccessStrategy(accessStrategy);
		serviceRegistryDao.setRegisteredServices(Lists.<RegisteredService>newArrayList(registeredService));
		return serviceRegistryDao;
	}
}
