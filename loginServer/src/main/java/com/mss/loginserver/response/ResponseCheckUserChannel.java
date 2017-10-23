package com.mss.loginserver.response;
/**
 * 
 * @author sametsafkan
 *
 */
public class ResponseCheckUserChannel {

	private boolean isChannelOk;
	private boolean errorCode;
	private boolean errorDesc;
	
	public boolean isChannelOk() {
		return isChannelOk;
	}
	public void setChannelOk(boolean isChannelOk) {
		this.isChannelOk = isChannelOk;
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
