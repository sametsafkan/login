package com.mss.tokenservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author sametsafkan
 *
 */
@RestController
public class TokenController {
	
	@Autowired TokenService tokenService;
	
	@RequestMapping("/validateToken")
	public boolean validateToken(@RequestBody String token) {
		return tokenService.validateToken(token);
	}
	
	@RequestMapping("/generateToken")
	public String generateToken() {
		return tokenService.generateToken();
	}
	
	public TokenController(TokenService tokenService) {
		this.tokenService = tokenService;
	}
}
