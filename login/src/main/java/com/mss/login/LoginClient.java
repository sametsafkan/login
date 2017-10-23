package com.mss.login;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mss.login.request.RequestLogin;
import com.mss.login.response.ResponseLogin;

/**
 * 
 * @author sametsafkan
 *
 */
@FeignClient("LOGIN-SERVER")
public interface LoginClient {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseLogin login(RequestLogin request);
}
