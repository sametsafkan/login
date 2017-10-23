package com.mss.loginserver.request;

/**
 * 
 * @author sametsafkan
 *
 */
public class RequestLoginUser {

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
	
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	public String getChannel() {
		return channel;
	}
	
	public RequestLoginUser(Integer clientNumber, String password, String channel) {
		this.clientNumber = clientNumber;
		this.password = password;
		this.channel = channel;
	}
}
