package com.mss.loginserver.request;

public class RequestValidateLogin {

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
	
	public RequestValidateLogin(Integer clientNumber, String password, String channel) {
		this.clientNumber = clientNumber;
		this.password = password;
		this.channel = channel;
	}
}
