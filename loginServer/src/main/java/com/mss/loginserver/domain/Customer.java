package com.mss.loginserver.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
/**
 * 
 * @author sametsafkan
 *
 */
@Data
@Document(collection = "Customer")
public class Customer {

	@Id
	private String id;
	private Integer customerNumber;
	private String name;
	private String surname;
	private String passwordId;
	
	public Customer() {
		
	}
	
	public Customer(Integer customerNumber, String name, String surname, String passwordId) {
		this.customerNumber = customerNumber;
		this.name = name;
		this.surname = surname;
		this.passwordId = passwordId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getPasswordId() {
		return passwordId;
	}
}
