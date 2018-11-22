package com.mss.loginserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mss.loginserver.request.RequestByClientNumber;

/**
 * 
 * @author sametsafkan
 *
 */
@FeignClient("OTP-SERVICE")
public interface OtpService {

	@RequestMapping("/")
	public void sendOtp(@RequestBody RequestByClientNumber request);
}
