package com.mss.loginserver.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mss.loginserver.domain.Customer;

import reactor.core.publisher.Mono;

/**
 * 
 * @author sametsafkan
 *
 */
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

	Mono<Customer> findByCustomerNumber(Integer customerNumber);
}
