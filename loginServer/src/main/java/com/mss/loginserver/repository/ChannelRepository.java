package com.mss.loginserver.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mss.loginserver.domain.Channel;

import reactor.core.publisher.Mono;

/**
 * 
 * @author sametsafkan
 *
 */
public interface ChannelRepository extends ReactiveMongoRepository<Channel, String> {

	Mono<Channel> findByClientNumberAndChannel(Integer clientNumber, String channel);
}
