package com.mss.otpservice.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mss.otpservice.request.RequestByClientNumber;

/**
 * 
 * @author sametsafkan
 *
 */
@RestController
public class OtpService {

	@RequestMapping("/")
	public void sendOtp(@RequestBody RequestByClientNumber request) {
		System.out.println(request.getClientNumber() + " numaralı müşteriye otp gönderildi");
	}
}
