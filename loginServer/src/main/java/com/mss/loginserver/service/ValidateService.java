package com.mss.loginserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mss.loginserver.request.RequestCheckChannel;
import com.mss.loginserver.request.RequestPasswordCheck;
import com.mss.loginserver.request.RequestValidateLogin;
import com.mss.loginserver.response.ResponseCheckPassword;
import com.mss.loginserver.response.ResponseCheckUserChannel;
import com.mss.loginserver.response.ResponseValidateLogin;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

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

	private ResponseCheckUserChannel responseCheckUserChannel;
	private ResponseCheckPassword responseCheckPassword;
	private boolean channelValidation;
	private boolean passwordValidation;

	public ResponseValidateLogin validateLogin(RequestValidateLogin requestValidateLogin) {
		ResponseValidateLogin response = new ResponseValidateLogin();
		RequestPasswordCheck requestPasswordCheck = new RequestPasswordCheck(requestValidateLogin.getClientNumber(), requestValidateLogin.getPassword());
		RequestCheckChannel requestCheckChannel = new RequestCheckChannel(requestValidateLogin.getClientNumber(), requestValidateLogin.getChannel());
		Observable.merge(checkChannel(requestCheckChannel), checkPassword(requestPasswordCheck)).blockingSubscribe();
		System.out.println(responseCheckUserChannel.isChannelOk());
		System.out.println(responseCheckPassword.isPasswordOk());
		if(responseCheckUserChannel.isChannelOk() & responseCheckPassword.isPasswordOk())
			response.setValidated(true);
		else
			response.setValidated(false);
		return response;
	}

	private Observable<RequestCheckChannel> checkChannel(RequestCheckChannel request) {
		Observable<RequestCheckChannel> todoObservable = Observable.just(request);
		todoObservable.subscribeOn(Schedulers.newThread()).doOnNext(
				// onNext
				(requestChannel) -> {
					responseCheckUserChannel = channelService.CheckUserChannel(requestChannel);
				});
		return todoObservable;
	}

	private Observable<RequestPasswordCheck> checkPassword(RequestPasswordCheck request) {
		Observable<RequestPasswordCheck> passwordObservable = Observable.just(request);
		passwordObservable.subscribeOn(Schedulers.newThread()).doOnNext(
				(requestPassword) -> {
					responseCheckPassword = passwordService.checkPassword(requestPassword);
				});
		return passwordObservable;
	}
}
