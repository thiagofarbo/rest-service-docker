package br.com.example.docker.repository.details;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.example.docker.model.Customer;

public class CustomerRepositoryDetails extends Customer implements UserDetails{
	
	private static final long serialVersionUID = -1432837033555655087L;
	
    private Long id;
	private String email;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	public CustomerRepositoryDetails(Long id, String email, String password, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	
	public CustomerRepositoryDetails(Customer customer) {
		super(customer);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getAuthorities();
	}

	@Override
	public String getUsername() {
		return this.getEmail();
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
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public String getPassword() {
		return super.getPassword();
	}
}