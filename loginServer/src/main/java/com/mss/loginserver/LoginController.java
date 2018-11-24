package com.mss.loginserver;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mss.loginserver.entity.CustomerEntity;
import com.mss.loginserver.repository.CustomerRepository;
import com.mss.loginserver.request.RequestLogin;
import com.mss.loginserver.request.RequestLoginUser;
import com.mss.loginserver.response.ResponseLogin;
import com.mss.loginserver.service.LoginService;

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
	public ResponseLogin login(@RequestBody RequestLogin request) {
		RequestLoginUser requestLoginUser = new RequestLoginUser(request.getClientNumber(), request.getPassword(), request.getChannel());
		ResponseLogin reponse = login.login(requestLoginUser);
		rabbitTemplate.convertAndSend(LoginServerApplication.queueName, request.getClientNumber());
		return reponse;
	}
	@RequestMapping(value="/")
	public Iterable<CustomerEntity> info(RequestLogin request) {
		return  customerRepository.findAll();
	}
	
	@Autowired
	public LoginController(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
}
