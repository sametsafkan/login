package com.mss.loginserver;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mss.loginserver.entity.CustomerEntity;
import com.mss.loginserver.repository.CustomerRepository;
import com.mss.loginserver.request.RequestLogin;
import com.mss.loginserver.request.RequestLoginUser;
import com.mss.loginserver.request.RequestSendOtp;
import com.mss.loginserver.response.ResponseLogin;
import com.mss.loginserver.service.LoginService;
import com.mss.loginserver.service.OtpService;

@RestController
public class LoginController {

	@Autowired
	DataLoader dataLoader;
	@Autowired
	LoginService login;
	@Autowired
	CustomerRepository customerRepository;
	private final RabbitTemplate rabbitTemplate;
	private final OtpService otpService;
	private final ConfigurableApplicationContext contex;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseLogin login(@RequestBody RequestLogin request) {
		RequestLoginUser requestLoginUser = new RequestLoginUser(request.getClientNumber(), request.getPassword(), request.getChannel());
		ResponseLogin reponse = login.login(requestLoginUser);
		RequestSendOtp requestSendOtp = new RequestSendOtp(request.getClientNumber());
		rabbitTemplate.convertAndSend(LoginServerApplication.queueName, requestSendOtp);
		return reponse;
	}
	@RequestMapping(value="/")
	public Iterable<CustomerEntity> info(RequestLogin request) {
		return  customerRepository.findAll();
	}
	
	@Autowired
	public LoginController(RabbitTemplate rabbitTemplate, OtpService otpService, ConfigurableApplicationContext contex) {
		this.rabbitTemplate = rabbitTemplate;
		this.otpService = otpService;
		this.contex = contex;
	}
}
