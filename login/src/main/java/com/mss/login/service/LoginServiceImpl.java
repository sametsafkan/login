package com.mss.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mss.login.LoginClient;
import com.mss.login.intf.LoginService;
import com.mss.login.request.RequestLogin;
import com.mss.login.response.ResponseLogin;
/**
 * 
 * @author sametsafkan
 *
 */
@Service
public class LoginServiceImpl implements LoginService{

	LoginClient login;
	
	@Override
	public ResponseLogin login(RequestLogin request) {
		return login.login(request);
	}
	
	@Autowired
	public void setLoginService(LoginClient login) {
		this.login = login;
	}

}
