package com.mss.tokenservice;

import org.springframework.stereotype.Service;

/**
 * 
 * @author sametsafkan
 *
 */
@Service
public class TokenService {

	public boolean validateToken(String token) {
		return true;
	}

	public String generateToken() {
		return "asbkl-aswe-qwqw-fgfgf";
	}
}
