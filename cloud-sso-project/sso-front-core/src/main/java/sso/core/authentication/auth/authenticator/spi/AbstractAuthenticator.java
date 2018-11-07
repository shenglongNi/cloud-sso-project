package sso.core.authentication.auth.authenticator.spi;

import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.springframework.beans.factory.annotation.Autowired;

import sso.core.authentication.invoker.spi.IServiceInvoker;

public abstract class AbstractAuthenticator implements IAuthenticator{

	@Autowired
	protected IServiceInvoker serviceInvoker;
	
	@Override
	public boolean doAuth(Credential credential) throws Exception {
		
		UsernamePasswordCredential castCredential = (UsernamePasswordCredential) credential;
		String username = castCredential.getUsername();
		String password = castCredential.getPassword();
		
		return authenInner(username, password);
	}
	
	protected abstract boolean authenInner(String loginId, String password) throws Exception;
}
