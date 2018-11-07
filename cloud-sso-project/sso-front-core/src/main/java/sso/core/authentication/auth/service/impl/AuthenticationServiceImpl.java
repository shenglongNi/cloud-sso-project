package sso.core.authentication.auth.service.impl;

import org.jasig.cas.authentication.Credential;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sso.core.authentication.auth.authenticator.spi.IAuthenticator;
import sso.core.authentication.auth.service.IAuthenticationService;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService{

	private static Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
	
	/**
	 * 不同的登录类型应有不同的	authenticator	
	 */
	@Autowired
	private IAuthenticator authenticator;
	
	@Override
	public boolean authenicate(Credential credential) throws Exception {
		
		return authenticator.doAuth(credential);
	}

}
