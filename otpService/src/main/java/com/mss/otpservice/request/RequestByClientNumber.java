package com.mss.otpservice.request;

/**
 * 
 * @author sametsafkan
 *
 */
public class RequestByClientNumber {

	private Integer clientNumber;

	public Integer getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(Integer clientNumber) {
		this.clientNumber = clientNumber;
	}
	
	public RequestByClientNumber(Integer clientNumber) {
		this.clientNumber = clientNumber;
	}
	
	public RequestByClientNumber() {
	}
}
