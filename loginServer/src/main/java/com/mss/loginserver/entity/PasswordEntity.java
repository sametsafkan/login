package com.mss.loginserver.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * 
 * @author sametsafkan
 *
 */
@Entity
@Data
public class PasswordEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	private String password;
	private Date createDate;
	
	@OneToOne(mappedBy = "password")
	private CustomerEntity customer;
	
	public PasswordEntity() {
		
	}
	
	public PasswordEntity(String password, Date createDate) {
		this.password = password;
		this.createDate = createDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
