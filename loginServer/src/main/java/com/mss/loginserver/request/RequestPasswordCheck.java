package com.mss.loginserver.request;

/**
 * 
 * @author sametsafkan
 *
 */
public class RequestPasswordCheck {

	private Integer clientNumber;
	private String password;

	public Integer getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(Integer clientNumber) {
		this.clientNumber = clientNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public RequestPasswordCheck(Integer clientNumber, String password) {
		this.clientNumber = clientNumber;
		this.password = password;
	}
}
