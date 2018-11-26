package com.mss.loginserver.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author sametsafkan
 *
 */
@Document(collection = "Channel")
public class Channel {

	@Id
	private String id;
	private Integer clientNumber;
	private String channel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(Integer clientNumber) {
		this.clientNumber = clientNumber;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannelList(String channel) {
		this.channel = channel;
	}

	public Channel(Integer clientNumber, String channel) {
		this.clientNumber = clientNumber;
		this.channel = channel;
	}

	public Channel() {

	}
}
