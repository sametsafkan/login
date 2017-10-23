package com.mss.loginserver.response;
/**
 * 
 * @author sametsafkan
 *
 */
public class ResponseCheckPassword {

	private boolean isPasswordOk;
	private boolean errorCode;
	private boolean errorDesc;
	
	public boolean isPasswordOk() {
		return isPasswordOk;
	}
	public void setPasswordOk(boolean isPasswordOk) {
		this.isPasswordOk = isPasswordOk;
	}
	public boolean isErrorCode() {
		return errorCode;
	}
	public void setErrorCode(boolean errorCode) {
		this.errorCode = errorCode;
	}
	public boolean isErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(boolean errorDesc) {
		this.errorDesc = errorDesc;
	}
}
