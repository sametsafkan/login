package com.mss.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 
 * @author sametsafkan
 *
 */

import com.mss.login.intf.LoginService;
import com.mss.login.request.RequestLogin;
import com.mss.login.response.ResponseLogin;

import reactor.core.publisher.Mono;
/**
 * 
 * @author sametsafkan
 *
 */
@Controller
public class LoginController {
	
	LoginService login;
		
	@RequestMapping(value = "/index.do")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/login.do")
	public Mono<String> login(@RequestParam("userName") Integer userName ,   
            			  @RequestParam("password") String password) {
		RequestLogin request = new RequestLogin();
		request.setClientNumber(userName);
		request.setPassword(password);
		request.setChannel("INT");
		Mono<ResponseLogin> responseMono = login.login(request);
	    return responseMono.map(m -> {
			if(m.getIsLogin()) {
				return "login-success";
			}else {
				return "login-fail";
			}
		});
	}
	
	@Autowired
	public void setLoginService(LoginService login) {
		this.login = login;
	}
}