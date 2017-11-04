package com.mss.loginserver.request;

import java.io.Serializable;

/**
 * 
 * @author sametsafkan
 *
 */
public class RequestByClientNumber implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
