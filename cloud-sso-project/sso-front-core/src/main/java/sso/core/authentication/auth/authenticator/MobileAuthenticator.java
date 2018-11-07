package sso.core.authentication.auth.authenticator;

import org.jasig.cas.authentication.Credential;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import sso.core.authentication.auth.authenticator.spi.AbstractAuthenticator;
import sso.core.authentication.exception.IdmException;
import sso.core.authentication.exception.LoginFailureType;

@Component
public class MobileAuthenticator extends AbstractAuthenticator{

	private static Logger logger = LoggerFactory.getLogger(MobileAuthenticator.class);
	@Override
	protected boolean authenInner(String loginId, String password) throws IdmException {
		
		Long userId = serviceInvoker.getUserIdByMobile(loginId);
		if(userId == null) {
			logger.info("[{}]用户不存在！", loginId);
			throw new IdmException(LoginFailureType.USER_NOT_EXISTS, loginId + "：用户不存在！");
		}
		
		return false;
	}

	@Override
	public String getUserId(Credential credential) throws Exception {
		
		return null;
	}


}
