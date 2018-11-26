package com.mss.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.mss.login.intf.LoginService;
import com.mss.login.request.RequestLogin;
import com.mss.login.response.ResponseLogin;

import reactor.core.publisher.Mono;

/**
 * 
 * @author sametsafkan
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Override
	public Mono<ResponseLogin> login(RequestLogin request) {
		WebClient client = WebClient.create(discoveryClient.getInstances("LOGIN-SERVER").get(0).getUri().toString());
		Mono<ResponseLogin> response = 
				client
					.post()
					.uri("/login")
					.body(BodyInserters.fromObject(request))
					.retrieve()
					.bodyToMono(ResponseLogin.class);
		return response;
	}
}
