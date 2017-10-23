package com.mss.loginserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mss.loginserver.entity.CustomerEntity;

/**
 * 
 * @author sametsafkan
 *
 */
@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

	public CustomerEntity findByCustomerNumber(Integer customerNumber);
}
