package sso.core.authentication.principal.resolver;

import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.principal.PersonDirectoryPrincipalResolver;

public class CustomPrincipalResolver extends PersonDirectoryPrincipalResolver{

	@Override
	protected String extractPrincipalId(Credential credential) {
		// TODO here to resolve userId
		
		return "112233";
	}

	
	
	
}
