package com.mss.loginserver.response;
/**
 * 
 * @author sametsafkan
 *
 */
public class ResponseValidateUserForLogin {

	private boolean isUserValidated;
	private Integer errorCode;
	private String errorDesc;
	
	public boolean isUserValidated() {
		return isUserValidated;
	}
	public void setUserValidated(boolean isUserValidated) {
		this.isUserValidated = isUserValidated;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
}
