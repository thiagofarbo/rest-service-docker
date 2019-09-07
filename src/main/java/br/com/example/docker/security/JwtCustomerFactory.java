package br.com.example.docker.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.example.docker.enums.ProfileEnum;
import br.com.example.docker.model.Customer;
import br.com.example.docker.repository.details.CustomerRepositoryDetails;

public class JwtCustomerFactory {

	private JwtCustomerFactory() {
	}

	public static CustomerRepositoryDetails create(Customer customer) {
		return new CustomerRepositoryDetails(customer.getId(), customer.getEmail(), customer.getPassword(),
				mapToGrantedAuthorities(customer.getProfile()));
	}

	
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}
	
}
