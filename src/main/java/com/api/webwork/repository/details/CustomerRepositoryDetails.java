package com.api.webwork.repository.details;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.api.webwork.model.Customer;

public class CustomerRepositoryDetails extends Customer implements UserDetails{
	
	private static final long serialVersionUID = -1432837033555655087L;
	
	private String username;
	private String passwordCustomerDetail;
	private Collection<? extends GrantedAuthority> authorities;

	public CustomerRepositoryDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		this.username = username;
		this.passwordCustomerDetail = password;
		this.authorities = authorities;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public String getPassword() {
		return passwordCustomerDetail;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
