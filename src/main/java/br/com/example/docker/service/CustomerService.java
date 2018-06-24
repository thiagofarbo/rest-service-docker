/**
 * @author thiagoemidio
 */


package br.com.example.docker.service;

import java.util.List;

import br.com.example.docker.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.docker.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomers(){

		return this.customerRepository.findAll();
	}
}
