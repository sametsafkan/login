package com.mss.loginserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mss.loginserver.response.ResponseValidateUserForLogin;

/**
 * 
 * @author sametsafkan
 *
 */
@Service
public class UserService {

	@Autowired
	ValidateService validateService;
	
	public ResponseValidateUserForLogin validateUserForLogin(Integer clientNumber, String password) {
		ResponseValidateUserForLogin response = new ResponseValidateUserForLogin();
/*		ResponseValidateLogin responseValidateLogin = validateService.validateLogin(clientNumber, password);
		response.setUserValidated(responseValidateLogin.isValidated());
		response.setErrorCode(responseValidateLogin.getErrorCode());
		response.setErrorDesc(responseValidateLogin.getErrorDesc());*/
		return response;
	}
}
