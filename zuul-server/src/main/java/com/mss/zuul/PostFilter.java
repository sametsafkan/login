package com.mss.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 
 * @author sametsafkan
 *
 */
public class PostFilter extends ZuulFilter{
	
	private static Logger log = LoggerFactory.getLogger(PostFilter.class);

	@Autowired
	TokenServiceClient tokenService;

	public PostFilter(TokenServiceClient tokenService) {
		this.tokenService = tokenService;
	}
	
	public PostFilter() {
	}
	
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		String token = tokenService.generateToken();
		ctx.getResponse().addHeader("token", token);
		log.debug("Zuul Proxy Post Filter token : " + token);
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String filterType() {
		return "post";
	}

}
