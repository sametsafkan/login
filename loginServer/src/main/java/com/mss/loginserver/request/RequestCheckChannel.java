package com.mss.loginserver.request;

/**
 * 
 * @author sametsafkan
 *
 */
public class RequestCheckChannel {

	private Integer clientNumber;
	private String channel;

	public Integer getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(Integer clientNumber) {
		this.clientNumber = clientNumber;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public RequestCheckChannel(Integer clientNumber, String channel) {
		this.clientNumber = clientNumber;
		this.channel = channel;
	}
}
