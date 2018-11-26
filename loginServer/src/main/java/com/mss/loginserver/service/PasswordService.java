package com.mss.loginserver.service;

import org.springframework.stereotype.Service;

import com.mss.loginserver.domain.Customer;
import com.mss.loginserver.domain.Password;
import com.mss.loginserver.repository.CustomerRepository;
import com.mss.loginserver.repository.PasswordRepository;
import com.mss.loginserver.request.RequestPasswordCheck;
import com.mss.loginserver.response.ResponseCheckPassword;

import reactor.core.publisher.Mono;

/**
 * 
 * @author sametsafkan
 *
 */
@Service
public class PasswordService {
	
	private final CustomerRepository customerRepository;
	private final PasswordRepository passwordRepository;
	
	public PasswordService(CustomerRepository customerRepository,
			PasswordRepository passwordRepository) {
		this.customerRepository = customerRepository;
		this.passwordRepository = passwordRepository;
	}
	
	public ResponseCheckPassword checkPassword(RequestPasswordCheck request) {
		ResponseCheckPassword response = new ResponseCheckPassword();
		Mono<Customer> entity = customerRepository.findByCustomerNumber(request.getClientNumber());
		Mono<Password> password = passwordRepository.findById(entity.block().getPasswordId());
		String pass = password.block().getPassword();
		if(pass.equals(request.getPassword()))
			response.setPasswordOk(true);
		else
			response.setPasswordOk(false);
		return response;
	}
}
