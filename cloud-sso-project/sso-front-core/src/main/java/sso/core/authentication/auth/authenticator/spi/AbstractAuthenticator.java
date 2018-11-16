
package sso.core.authentication.auth.authenticator.spi;

import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.springframework.beans.factory.annotation.Autowired;

import sso.core.authentication.exception.IdmException;
import sso.core.authentication.invoker.spi.IServiceInvoker;
import cloud.sso.domain.User;

public abstract class AbstractAuthenticator implements IAuthenticator{

	@Autowired
	protected IServiceInvoker serviceInvoker;
	
	protected static ThreadLocal<Long> local = new ThreadLocal<Long>(); 
	
	@Override
	public boolean doAuth(Credential credential) throws Exception {
		local.set(null);
		UsernamePasswordCredential castCredential = (UsernamePasswordCredential) credential;
		String username = castCredential.getUsername();
		String password = castCredential.getPassword();
		
		return authenInner(username, password);
	}
	
	protected abstract boolean authenInner(String loginId, String password) throws Exception;
	
	protected void handlerUserStatus(User user) throws IdmException {
		// TODO
	}
}

