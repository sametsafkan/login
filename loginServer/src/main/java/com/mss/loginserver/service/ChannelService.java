package com.mss.loginserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mss.loginserver.entity.ChannelEntity;
import com.mss.loginserver.repository.ChannelRepository;
import com.mss.loginserver.request.RequestCheckChannel;
import com.mss.loginserver.response.ResponseCheckUserChannel;

/**
 * 
 * @author sametsafkan
 *
 */
@Service
public class ChannelService {

	private ChannelRepository channel;

	@Autowired
	public ChannelService(ChannelRepository channel) {
		this.channel = channel;
	}

	public ResponseCheckUserChannel CheckUserChannel(RequestCheckChannel request) {
		ResponseCheckUserChannel response = new ResponseCheckUserChannel();
		ChannelEntity entity = channel.findByClientNumberAndChannel(request.getClientNumber(), request.getChannel());
		if(entity == null)
			response.setChannelOk(false) ;
		else
			response.setChannelOk(true);
		return response;
	}
}
