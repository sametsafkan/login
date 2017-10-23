package com.mss.login.intf;

import com.mss.login.request.RequestLogin;
import com.mss.login.response.ResponseLogin;
/**
 * 
 * @author sametsafkan
 *
 */
public interface LoginService {

	ResponseLogin login(RequestLogin request);
}
