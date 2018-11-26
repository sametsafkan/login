package com.mss.login.intf;

import com.mss.login.request.RequestLogin;
import com.mss.login.response.ResponseLogin;

import reactor.core.publisher.Mono;
/**
 * 
 * @author sametsafkan
 *
 */
public interface LoginService {

	Mono<ResponseLogin> login(RequestLogin request);
}
