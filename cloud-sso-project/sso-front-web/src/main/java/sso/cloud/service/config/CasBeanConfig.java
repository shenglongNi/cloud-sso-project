package sso.cloud.service.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.jasig.cas.CentralAuthenticationService;
import org.jasig.cas.CentralAuthenticationServiceImpl;
import org.jasig.cas.authentication.AuthenticationHandler;
import org.jasig.cas.authentication.AuthenticationManager;
import org.jasig.cas.authentication.PolicyBasedAuthenticationManager;
import org.jasig.cas.authentication.principal.PrincipalResolver;
import org.jasig.cas.authentication.principal.SimpleWebApplicationServiceImpl;
import org.jasig.cas.logout.LogoutManager;
import org.jasig.cas.logout.LogoutManagerImpl;
import org.jasig.cas.logout.SamlCompliantLogoutMessageCreator;
import org.jasig.cas.services.DefaultRegisteredServiceAccessStrategy;
import org.jasig.cas.services.DefaultServicesManagerImpl;
import org.jasig.cas.services.InMemoryServiceRegistryDaoImpl;
import org.jasig.cas.services.RegexRegisteredService;
import org.jasig.cas.services.RegisteredService;
import org.jasig.cas.services.ServiceRegistryDao;
import org.jasig.cas.services.ServicesManager;
import org.jasig.cas.ticket.registry.DefaultTicketRegistry;
import org.jasig.cas.ticket.registry.TicketRegistry;
import org.jasig.cas.ticket.support.HardTimeoutExpirationPolicy;
import org.jasig.cas.ticket.support.TicketGrantingTicketExpirationPolicy;
import org.jasig.cas.util.DefaultUniqueTicketIdGenerator;
import org.jasig.cas.util.UniqueTicketIdGenerator;
import org.jasig.cas.util.http.HttpClient;
import org.jasig.cas.util.http.SimpleHttpClientFactoryBean;
import org.jasig.cas.web.support.ArgumentExtractor;
import org.jasig.cas.web.support.CasArgumentExtractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import sso.cloud.authentication.handler.MobileAuthenticationHandler;
import sso.core.authentication.principal.resolver.CustomPrincipalResolver;
import sso.core.authentication.service.registry.UrlBasedRegisteredService;

@Configuration
public class CasBeanConfig {

	private Logger logger = LoggerFactory.getLogger(MobileAuthenticationHandler.class);

	@Bean
	public CentralAuthenticationService getCentralAuthenticationService(
			TicketRegistry ticketRegistry,
			AuthenticationManager authenticationManager,
			UniqueTicketIdGenerator ticketGrantingTicketUniqueTicketIdGenerator,
			Map<String, UniqueTicketIdGenerator> uniqueTicketIdGeneratorsForService,
			TicketGrantingTicketExpirationPolicy ticketGrantingTicketExpirationPolicy,
			HardTimeoutExpirationPolicy serviceTicketExpirationPolicy,
			ServicesManager servicesManager, LogoutManager logoutManager

	) {
		CentralAuthenticationService authenticationService = new CentralAuthenticationServiceImpl(
				ticketRegistry, authenticationManager,
				ticketGrantingTicketUniqueTicketIdGenerator,
				uniqueTicketIdGeneratorsForService,
				ticketGrantingTicketExpirationPolicy,
				serviceTicketExpirationPolicy, servicesManager, logoutManager);

		return authenticationService;
	}
	
	@Bean
	public TicketRegistry ticketRegistry() {
		
		return new DefaultTicketRegistry();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationHandler mobileAuthenticationHandler) {
		Map<AuthenticationHandler, PrincipalResolver> handlerResolverMap = Maps.newHashMap();
		handlerResolverMap.put(mobileAuthenticationHandler, new CustomPrincipalResolver());
		AuthenticationManager authManager = new PolicyBasedAuthenticationManager(handlerResolverMap);
		return authManager;
	}
	
	@Bean
	public UniqueTicketIdGenerator ticketIdGenerator() {
		logger.info("====init successful");
		return new DefaultUniqueTicketIdGenerator(); 
	}
	
	@Bean
	public Map<String, UniqueTicketIdGenerator> uniqueTicketIdGeneratorsForService(UniqueTicketIdGenerator UniqueTicketIdGenerator) {
		return ImmutableMap.of(SimpleWebApplicationServiceImpl.class.getName(), UniqueTicketIdGenerator);
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
	public ServiceRegistryDao serviceRegistryDao(RegisteredService registeredService) {
		InMemoryServiceRegistryDaoImpl serviceRegistryDao = new InMemoryServiceRegistryDaoImpl();
		//TODO 此处需要扩展自定义的RegisteredService
//		RegexRegisteredService registeredService1 = new  RegexRegisteredService();
		/*registeredService1.setServiceId("localhost");
		registeredService1.setId(1);
		registeredService1.setEvaluationOrder(1);
		registeredService1.setName("localhost");
		
		RegexRegisteredService registeredService2 = new  RegexRegisteredService();
		registeredService2.setServiceId("http://localhost:8080/idm/test");
		registeredService2.setId(1);
		registeredService2.setEvaluationOrder(1);
		registeredService2.setName("localhost");
		
		DefaultRegisteredServiceAccessStrategy accessStrategy = new DefaultRegisteredServiceAccessStrategy();
		accessStrategy.setEnabled(true);
		accessStrategy.setSsoEnabled(true);
		registeredService1.setAccessStrategy(accessStrategy);
		registeredService2.setAccessStrategy(accessStrategy);*/
		
		serviceRegistryDao.setRegisteredServices(Lists.<RegisteredService>newArrayList(registeredService));
		return serviceRegistryDao;
	}
	
	/**
	 * 扩展RegisteredService， 可信域名白名单UrlBasedRegisteredService
	 * @return
	 */
	@Bean
	public RegisteredService registeredService() {
		UrlBasedRegisteredService registeredService = new UrlBasedRegisteredService();
		DefaultRegisteredServiceAccessStrategy accessStrategy = new DefaultRegisteredServiceAccessStrategy();
		accessStrategy.setEnabled(true);
		accessStrategy.setSsoEnabled(true);
		registeredService.setAccessStrategy(accessStrategy);
		registeredService.setAllowServiceDomains(Lists.newArrayList("localhost"));
		registeredService.setName("");
		registeredService.setEvaluationOrder(1);
		registeredService.setServiceId("");
		return registeredService;
	}
	
	@Bean
	public ServicesManager servicesManager(ServiceRegistryDao serviceRegistryDao) {
		
		ServicesManager serviceManager = new DefaultServicesManagerImpl(serviceRegistryDao);
		
		return serviceManager;
	}
	
	@Bean
	public LogoutManager logoutManager(ServicesManager servicesManager, HttpClient httpClient, SamlCompliantLogoutMessageCreator logoutMessageCreator) {
		
		return new LogoutManagerImpl(servicesManager, httpClient, logoutMessageCreator);
	}
	
	@Bean
	public SamlCompliantLogoutMessageCreator logoutMessageCreator() {
		return new SamlCompliantLogoutMessageCreator();
	}
	
	@Bean
	public HttpClient casHttpClient() throws Exception {
		return new SimpleHttpClientFactoryBean().getObject();
	}
	
	/**
	 * CAS 默认的ArgumentExtractor 实现CasArgumentExtractor， 在分布式系统中，相同的应用实例部署在不同的服务器上， 
	 * 访问时通过域名，前端负载后选择其中一个实例。 此时若要登出，则需要扩展ArgumentExtractor， 保存场景端的服务ip，
	 * 登出时，通过IP:PORT 回调应用
	 * @return
	 */
	@Bean
	public List<ArgumentExtractor> casArgumentExtractors() {
		return Lists.newArrayList((ArgumentExtractor) new CasArgumentExtractor());
	}
}
