package com.mss.loginserver.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * 
 * @author sametsafkan
 *
 */
@Document(collection = "Password")
@Data
public class Password {
	
	@Id
	private String id;
	private String password;
	private LocalDateTime createDate;
	private String userId;
	
	public Password() {
		
	}
	
	public Password(String password, LocalDateTime createDate) {
		this.password = password;
		this.createDate = createDate;
	}
}
