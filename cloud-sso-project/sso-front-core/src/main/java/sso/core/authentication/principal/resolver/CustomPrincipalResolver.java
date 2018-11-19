
package sso.core.authentication.principal.resolver;

import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.principal.PersonDirectoryPrincipalResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import sso.core.authentication.auth.service.IAuthenticationService;

public class CustomPrincipalResolver extends PersonDirectoryPrincipalResolver{
	
	private static Logger logger = LoggerFactory.getLogger(CustomPrincipalResolver.class);
	
	@Autowired
	private IAuthenticationService authenticationService;
	
	@Override
	protected String extractPrincipalId(Credential credential) {
		
		try {
			
			UsernamePasswordCredential usernameAndPasswordCredential = (UsernamePasswordCredential) credential;
			return authenticationService.getUserId(usernameAndPasswordCredential.getUsername());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	
}
