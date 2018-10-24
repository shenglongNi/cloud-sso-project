package sso.cloud.authentication.handler;

import java.security.GeneralSecurityException;

import org.jasig.cas.authentication.AbstractAuthenticationHandler;
import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MobileAuthenticationHandler extends AbstractAuthenticationHandler {

	
	@Override
	public HandlerResult authenticate(Credential credential)
			throws GeneralSecurityException, PreventedException {
		
		return null;
	}

	@Override
	public boolean supports(Credential credential) {
		if(credential instanceof UsernamePasswordCredential) {
			return true;
		}
		
		return false;
	}

}
