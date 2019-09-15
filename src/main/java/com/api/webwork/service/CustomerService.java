/**
 * @author thiagoemidio
 */


package com.api.webwork.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.api.webwork.model.Customer;
import com.api.webwork.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Cacheable("cacheCustomers")
	public Page<Customer> getAllCustomers(final int page, final int size){
		log.info("##Getting customers...");
		return this.customerRepository.findAll(PageRequest.of(page, size));
	}
	
	public Optional<Customer> getCustomerByEmail(final String email) {
		return Optional.ofNullable(this.customerRepository.findByEmail(email));
	}
}
