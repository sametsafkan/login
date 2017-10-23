package com.mss.login.request;

import org.springframework.stereotype.Component;

/**
 * 
 * @author sametsafkan
 *
 */
@Component
public class RequestLogin {

	private Integer clientNumber;
	private String password;
	private String channel;

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

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
}
