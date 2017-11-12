package com.mss.zuul;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author sametsafkan
 *
 */
@FeignClient("token-service")
public interface TokenServiceClient {

	@RequestMapping("/validateToken")
	public boolean validateToken(@RequestBody String token);
	
	@RequestMapping("/generateToken")
	public String generateToken();
}
