package sso.core.authentication.exception;

public enum LoginFailureType {

	
	USER_NOT_EXISTS(1),
	
	SYSTEM_EXCEPTION(99);
	
	private int code;
	
	private LoginFailureType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static LoginFailureType fromInt(int code) {
		for(LoginFailureType type : LoginFailureType.values()) {
			if(type.getCode() == code) {
				return type;
			}
		}
		return null;
	}
}
