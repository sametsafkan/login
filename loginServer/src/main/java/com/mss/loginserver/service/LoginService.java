package com.mss.loginserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mss.loginserver.request.RequestLoginUser;
import com.mss.loginserver.request.RequestValidateLogin;
import com.mss.loginserver.response.ResponseLogin;
import com.mss.loginserver.response.ResponseValidateLogin;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 
 * @author sametsafkan
 *
 */
@Service
public class LoginService {
	
	@Autowired
	ValidateService validateService;

	@HystrixCommand(fallbackMethod="getFallbacklogin")
	public ResponseLogin login(RequestLoginUser request) {
		RequestValidateLogin requestValidateLogin = new RequestValidateLogin(request.getClientNumber(), request.getPassword(), request.getChannel());
		ResponseValidateLogin responseValidateLogin = validateService.validateLogin(requestValidateLogin);
		ResponseLogin response = new ResponseLogin();
		response.setIsLogin(responseValidateLogin.isValidated() == true ? "1" : "0");
		return response;
	}
	
	public ResponseLogin getFallbacklogin(RequestLoginUser request) {
		ResponseLogin response = new ResponseLogin();
		response.setIsLogin("1");
		return response;
	}
}
