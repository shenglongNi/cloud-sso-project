package sso.core.authentication.exception;

public class IdmException extends Exception{

	private static final long serialVersionUID = 1L;

	
	private LoginFailureType loginFailureType;
	
	public IdmException(LoginFailureType loginFailureType, String msg) {
		super(msg);
		this.loginFailureType = loginFailureType;
	}
	
}
