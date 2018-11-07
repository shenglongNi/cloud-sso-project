package sso.core.authentication.principal.resolver;

import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.principal.PersonDirectoryPrincipalResolver;

public class CustomPrincipalResolver extends PersonDirectoryPrincipalResolver{

	@Override
		// TODO here to resolve userId
	protected String extractPrincipalId(Credential credential) {
		
		return "112233";
	}

	
	
	
}
