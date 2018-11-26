package com.mss.loginserver.service;

import static reactor.core.publisher.Mono.fromCallable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mss.loginserver.request.RequestCheckChannel;
import com.mss.loginserver.request.RequestPasswordCheck;
import com.mss.loginserver.request.RequestValidateLogin;
import com.mss.loginserver.response.ResponseCheckPassword;
import com.mss.loginserver.response.ResponseCheckUserChannel;
import com.mss.loginserver.response.ResponseLogin;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * 
 * @author sametsafkan
 *
 */
@Service
public class ValidateService {

	@Autowired
	UserService userService;
	@Autowired
	ChannelService channelService;
	@Autowired
	PasswordService passwordService;


	public Mono<ResponseLogin> validateLogin(RequestValidateLogin requestValidateLogin) {
		ResponseLogin response = new ResponseLogin();
		RequestPasswordCheck requestPasswordCheck = 
				new RequestPasswordCheck(requestValidateLogin.getClientNumber(), requestValidateLogin.getPassword());
		RequestCheckChannel requestCheckChannel = 
				new RequestCheckChannel(requestValidateLogin.getClientNumber(), requestValidateLogin.getChannel());
		
		Mono<ResponseCheckUserChannel> checkChannel = 
				fromCallable(() -> checkChannel(requestCheckChannel)).subscribeOn(Schedulers.elastic());
		Mono<ResponseCheckPassword> checkPassword = 
				fromCallable(() -> checkPassword(requestPasswordCheck)).subscribeOn(Schedulers.elastic());
		return Mono.zip(checkChannel, checkPassword).map(tuple2 -> {
			boolean isValidated = tuple2.getT1().isChannelOk() && tuple2.getT2().isPasswordOk();
			response.setIsLogin(isValidated);
			return response;
		});
	}
	
	private ResponseCheckUserChannel checkChannel(RequestCheckChannel request) {
		return channelService.CheckUserChannel(request);
	}
	
	private ResponseCheckPassword checkPassword(RequestPasswordCheck request) {
		return passwordService.checkPassword(request);
	}
}
