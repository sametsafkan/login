package com.mss.loginserver;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mss.loginserver.domain.Customer;
import com.mss.loginserver.repository.CustomerRepository;
import com.mss.loginserver.request.RequestLogin;
import com.mss.loginserver.request.RequestLoginUser;
import com.mss.loginserver.response.ResponseLogin;
import com.mss.loginserver.service.LoginService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class LoginController {

	@Autowired
	DataLoader dataLoader;
	@Autowired
	LoginService login;
	@Autowired
	CustomerRepository customerRepository;
	private final RabbitTemplate rabbitTemplate;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public Mono<ResponseLogin> login(@RequestBody RequestLogin request) {
		RequestLoginUser requestLoginUser = new RequestLoginUser(request.getClientNumber(), request.getPassword(), request.getChannel());
		Mono<ResponseLogin> response = login.login(requestLoginUser);
		rabbitTemplate.convertAndSend(LoginServerApplication.queueName, request.getClientNumber());
		return response;
	}
	
	@GetMapping(value = "/getCustomers", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Customer> getCustomers() {
		return  customerRepository.findAll();
	}
	
	@Autowired
	public LoginController(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
}
