package com.mss.loginserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mss.loginserver.entity.CustomerEntity;
import com.mss.loginserver.repository.CustomerRepository;
import com.mss.loginserver.request.RequestPasswordCheck;
import com.mss.loginserver.response.ResponseCheckPassword;

/**
 * 
 * @author sametsafkan
 *
 */
@Service
public class PasswordService {
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public PasswordService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public ResponseCheckPassword checkPassword(RequestPasswordCheck request) {
		ResponseCheckPassword response = new ResponseCheckPassword();
		CustomerEntity entity = customerRepository.findByCustomerNumber(request.getClientNumber());
		if(entity == null) {
			response.setPasswordOk(false);
			return response;
		}
		String pass = entity.getPassword().getPassword();
		if(pass.equals(request.getPassword()))
			response.setPasswordOk(true);
		else
			response.setPasswordOk(false);
		return response;
	}

}
