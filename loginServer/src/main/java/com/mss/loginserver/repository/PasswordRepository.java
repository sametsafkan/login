package com.mss.loginserver.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mss.loginserver.domain.Password;

/**
 * 
 * @author sametsafkan
 *
 */
@Repository
public interface PasswordRepository extends ReactiveMongoRepository<Password, String> {

}
