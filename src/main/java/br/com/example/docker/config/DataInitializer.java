package br.com.example.docker.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.example.docker.model.Customer;
import br.com.example.docker.model.Roles;
import br.com.example.docker.repository.CustomerRepository;
import br.com.example.docker.repository.RoleRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	

//	@Autowired
//	public DataInitializer(PasswordEncoder passwordEncoder) {
//		this.passwordEncoder = passwordEncoder;
//	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		List<Customer> customers = this.customerRepository.findAll();
		
		if(customers.isEmpty()) {
			this.buildCustomer("Av. Brg. Faria Lima, 3477 - Itaim Bibi, São Paulo", "thiagofarbo@gmail.com", "Thiago", "@123456"/*passwordEncoder.encode("@123456")*/, "119099877", "ROLE_ADMIN");
		}
	}
	
	public void buildCustomer(String adrress, String email, String name, String password,  String phone, String role) {
		
		Roles roles = new Roles();
		roles.setName(role);
		
//		this.roleRepository.save(roles);
		
		Customer customer = new Customer(name, email, password, adrress, phone,  Arrays.asList(roles));
		
		this.customerRepository.save(customer);
		
	}
}