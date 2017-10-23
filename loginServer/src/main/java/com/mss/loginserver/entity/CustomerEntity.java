package com.mss.loginserver.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import lombok.Data;
/**
 * 
 * @author sametsafkan
 *
 */
@Data
@Entity
public class CustomerEntity {

	@Id
	@GeneratedValue
	private Long id;
	private Integer customerNumber;
	private String name;
	private String surname;
	
	@OneToOne
	private PasswordEntity password;
	
	public CustomerEntity() {
		
	}
	
	public CustomerEntity(Integer customerNumber, String name, String surname, PasswordEntity password) {
		this.customerNumber = customerNumber;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public PasswordEntity getPassword() {
		return password;
	}
}
