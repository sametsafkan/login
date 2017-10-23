package com.mss.loginserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mss.loginserver.entity.PasswordEntity;

/**
 * 
 * @author sametsafkan
 *
 */
@Repository
public interface PasswordRepository extends CrudRepository<PasswordEntity, Long> {

}
