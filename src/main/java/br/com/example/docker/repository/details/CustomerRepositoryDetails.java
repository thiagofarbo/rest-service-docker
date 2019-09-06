package br.com.example.docker.repository.details;

//import java.util.Collection;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import br.com.example.docker.model.Customer;
//
//public class CustomerRepositoryDetails extends Customer implements UserDetails{
//	
//	private static final long serialVersionUID = -1432837033555655087L;
//	
//	public CustomerRepositoryDetails(Customer customer) {
//		super(customer);
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
////		return getRoles();
//		return null;
//	}
//
//	@Override
//	public String getUsername() {
//		return this.getEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//	
//	@Override
//	public String getPassword() {
//		return super.getPassword();
//	}
//}