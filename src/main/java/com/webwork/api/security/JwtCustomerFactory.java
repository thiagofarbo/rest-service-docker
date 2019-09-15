package com.webwork.api.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.api.webwork.enums.ProfileEnum;
import com.api.webwork.model.Customer;
import com.api.webwork.repository.details.CustomerRepositoryDetails;

public class JwtCustomerFactory {

	private JwtCustomerFactory() {
	}

	/**
	 * Converte e gera um JwtUser com base nos dados de um funcionário.
	 * 
	 * @param funcionario
	 * @return JwtUser
	 */
	public static CustomerRepositoryDetails create(Customer customer) {
		return new CustomerRepositoryDetails(customer.getId(), customer.getEmail(), customer.getPassword(),
				mapToGrantedAuthorities(customer.getProfile()));
	}

	/**	
	 * Converte o perfil do usuário para o formato utilizado pelo Spring Security.
	 * 
	 * @param perfilEnum
	 * @return List<GrantedAuthority>
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}

}
