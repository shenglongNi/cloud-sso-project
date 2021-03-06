
package sso.core.authentication.auth.authenticator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import sso.core.authentication.auth.authenticator.spi.AbstractAuthenticator;
import sso.core.authentication.exception.IdmException;
import sso.core.authentication.exception.LoginFailureType;
import cloud.sso.domain.User;

@Component
public class MobileAuthenticator extends AbstractAuthenticator{

	private static Logger logger = LoggerFactory.getLogger(MobileAuthenticator.class);
	@Override
	protected boolean authenInner(String loginId, String password) throws IdmException {
		
		Long userId = serviceInvoker.getUserIdByMobile(loginId);
		if(userId == null) {
			logger.info("[{}]用户ID不存在！", loginId);
			throw new IdmException(LoginFailureType.USER_NOT_EXISTS, loginId + "：用户不存在！");
		}
		
		User user = serviceInvoker.getUser(userId);
		if(user == null) {
			logger.info("[{}]用户不存在！", userId);
			throw new IdmException(LoginFailureType.USER_NOT_EXISTS, loginId + "：用户不存在！");
		}
		handlerUserStatus(user);
		
		if(!serviceInvoker.VerifyPwd(userId, password)) {
			logger.info("[{}]用户密码错误！", userId);
			throw new IdmException(LoginFailureType.WRONG_PWD, "密码错误");
		}
		
		local.set(userId);
		return true;
	}

	@Override
	public String getUserId(String loginId) throws Exception {
		
		return String.valueOf(local.get());
	}
	

}
