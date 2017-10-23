package com.mss.loginserver.response;

/**
 * 
 * @author sametsafkan
 *
 */
public class ResponseValidateLogin {

	private boolean isValidated;
	private Integer errorCode;
	private String errorDesc;
	public boolean isValidated() {
		return isValidated;
	}
	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
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
