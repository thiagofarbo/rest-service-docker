package br.com.example.docker.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.example.docker.model.Customer;
import br.com.example.docker.service.CustomerService;

@Service
public class JwtCustomerDetailService implements UserDetailsService{
	
	@Autowired
	private CustomerService customerService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Customer> customer = customerService.getCustomerByEmail(username);
		
		if(customer.isPresent()) {
			return  JwtCustomerFactory.create(customer.get());
		}
		
		throw new UsernameNotFoundException("E-mail not found");
	}
}
