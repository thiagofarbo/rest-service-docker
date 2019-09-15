/**
 * @author thiagoemidio
 */


package com.api.webwork.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.api.webwork.model.Customer;
import com.api.webwork.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Page<Customer> getAllCustomers(final int page, final int size){

		return this.customerRepository.findAll(PageRequest.of(page, size));
	}
	
	public Optional<Customer> getCustomerByEmail(final String email) {
		return Optional.ofNullable(this.customerRepository.findByEmail(email));
	}
}
