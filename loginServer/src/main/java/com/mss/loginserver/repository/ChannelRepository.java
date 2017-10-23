package com.mss.loginserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mss.loginserver.entity.ChannelEntity;

/**
 * 
 * @author sametsafkan
 *
 */
@Repository
public interface ChannelRepository extends CrudRepository<ChannelEntity, Long> {

	public ChannelEntity findByClientNumberAndChannel(Integer clientNumber, String channel);
}
