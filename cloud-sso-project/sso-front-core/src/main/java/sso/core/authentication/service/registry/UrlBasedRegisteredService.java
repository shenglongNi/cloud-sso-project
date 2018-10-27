package sso.core.authentication.service.registry;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.jasig.cas.authentication.principal.Service;
import org.jasig.cas.services.AbstractRegisteredService;
import org.jasig.cas.services.DefaultRegisteredServiceAccessStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

public class UrlBasedRegisteredService extends AbstractRegisteredService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(UrlBasedRegisteredService.class);
	
	private List<String> allowServiceDomains = Lists.newArrayList();
	
	@Override
	public boolean matches(Service service) {
		
		if(service == null) {
			return false;
		}
		
		try {
			String serviceDomain = new URL(service.getId()).getHost();
			return allowServiceDomains.contains(serviceDomain);
		} catch (MalformedURLException e) {
			logger.error(e.getMessage(), e);
		}
		
		return false;
	}

	@Override
	public void setServiceId(String id) {
		this.serviceId = id;
	}

	@Override
	protected AbstractRegisteredService newInstance() {
		
		UrlBasedRegisteredService registeredService = new UrlBasedRegisteredService();
		return registeredService;
	}

	public void setAllowServiceDomains(List<String> allowServiceDomains) {
		this.allowServiceDomains = allowServiceDomains;
	}
	
	

}
