
package sso.core.authentication.auth.service;

import org.jasig.cas.authentication.Credential;

public interface IAuthenticationService {

	
	boolean authenicate(Credential credential) throws Exception;
	
	String getUserId(String loginId) throws Exception;
}
