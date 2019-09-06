package br.com.example.docker.service;

import java.util.Collection;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import br.com.example.docker.model.Customer;
//import br.com.example.docker.repository.CustomerRepository;
//
//@Service
//public class CustomerDetailsService implements UserDetailsService{
//	
//	@Autowired
//	private CustomerRepository customerRepository;
//	
//	@Autowired
//	public CustomerDetailsService(CustomerRepository customerRepository) {
//		this.customerRepository = customerRepository;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		Customer customer = this.customerRepository.findByEmail(username);
//		
//		if(customer == null){
//			throw new UsernameNotFoundException("User not found");
//		}
//		
//		return new CustomerRepositoryDetails(customer);
//	}
//	
//public class CustomerRepositoryDetails extends Customer implements UserDetails{
//
//		private static final long serialVersionUID = -1432837033555655087L;
//		
//		public CustomerRepositoryDetails(Customer customer) {
//			super(customer);
//		}
//
//		@Override
//		public Collection<? extends GrantedAuthority> getAuthorities() {
//			return getRoles();
//		}
//
//		@Override
//		public String getUsername() {
//			return this.getEmail();
//		}
//
//		@Override
//		public boolean isAccountNonExpired() {
//			return true;
//		}
//
//		@Override
//		public boolean isAccountNonLocked() {
//			return true;
//		}
//
//		@Override
//		public boolean isCredentialsNonExpired() {
//			return true;
//		}
//
//		@Override
//		public boolean isEnabled() {
//			return true;
//		}
//		
//		@Override
//		public String getPassword() {
//			return super.getPassword();
//		}
//	}
//}