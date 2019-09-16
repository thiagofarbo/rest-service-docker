/**
 * @author thiagoemidio
 */


package com.api.webwork.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.webwork.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{
	
	Customer findByEmail(String email);

}
