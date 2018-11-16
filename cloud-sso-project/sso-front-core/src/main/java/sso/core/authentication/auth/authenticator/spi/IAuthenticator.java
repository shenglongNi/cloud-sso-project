
package sso.core.authentication.auth.authenticator.spi;

import org.jasig.cas.authentication.Credential;

public interface IAuthenticator {

	boolean doAuth(Credential credential) throws Exception;
	
	String getUserId(String loginId) throws Exception;
}


