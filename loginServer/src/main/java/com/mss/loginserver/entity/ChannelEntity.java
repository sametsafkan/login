package com.mss.loginserver.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author sametsafkan
 *
 */
@Entity
public class ChannelEntity {

	@Id
	@GeneratedValue
	private Long id;
	private Integer clientNumber;
	private String channel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public ChannelEntity(Integer clientNumber, String channel) {
		this.clientNumber = clientNumber;
		this.channel = channel;
	}

	public ChannelEntity() {

	}
}
