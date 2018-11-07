package sso.cloud.authentication.handler;

import java.security.GeneralSecurityException;

import javax.security.auth.login.AccountNotFoundException;

import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractPreAndPostProcessingAuthenticationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sso.core.authentication.auth.service.IAuthenticationService;

@Component
public class MobileAuthenticationHandler extends AbstractPreAndPostProcessingAuthenticationHandler {

	private static Logger logger = LoggerFactory.getLogger(MobileAuthenticationHandler.class);
	
	@Autowired
	private IAuthenticationService authService;
	
	@Override
	public boolean supports(Credential credential) {
		return credential instanceof UsernamePasswordCredential;
	}

	@Override
	protected HandlerResult doAuthentication(Credential credential)
			throws GeneralSecurityException, PreventedException {
		
		UsernamePasswordCredential usernamepassword = (UsernamePasswordCredential) credential;
		
		String username = usernamepassword.getUsername();
		
		if(StringUtils.isBlank(username)) {
			logger.error("用户名为空， 认证失败!");
			throw new AccountNotFoundException("用户名为空！");
		}
		
		try {
			authService.authenicate(credential);
		} catch (Exception e) {
			throw new GeneralSecurityException();
		}
		
		
		return createHandlerResult(credential, this.principalFactory.createPrincipal(username), null);
	}

	

}
