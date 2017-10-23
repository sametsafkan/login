package com.mss.loginserver.service;

import org.springframework.stereotype.Service;

import com.mss.loginserver.request.RequestSendOtp;

/**
 * 
 * @author sametsafkan
 *
 */
@Service
public class OtpService {

	public void sendOtp(RequestSendOtp request) {
		System.out.println(request.getClientNumber() + "Otp Gönderildi");
	}
}
