package com.mss.loginserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mss.loginserver.request.RequestLoginUser;
import com.mss.loginserver.request.RequestValidateLogin;
import com.mss.loginserver.response.ResponseLogin;
import com.mss.loginserver.response.ResponseValidateLogin;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import reactor.core.publisher.Mono;

/**
 * 
 * @author sametsafkan
 *
 */
@Service
public class LoginService {
	
	@Autowired
	ValidateService validateService;

	public Mono<ResponseLogin> login(RequestLoginUser request) {
		RequestValidateLogin requestValidateLogin = new RequestValidateLogin(request.getClientNumber(), request.getPassword(), request.getChannel());
		Mono<ResponseLogin> validateLogin = validateService.validateLogin(requestValidateLogin);
		return validateLogin;
	}
	
	public Mono<ResponseLogin> getFallbacklogin(RequestLoginUser request) {
		ResponseLogin response = new ResponseLogin();
		response.setIsLogin(true);
		return Mono.just(response);
	}
}
