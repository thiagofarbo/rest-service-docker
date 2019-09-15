package com.api.webwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.api.webwork.enums.ProfileEnum;
import com.api.webwork.model.Customer;
import com.api.webwork.repository.CustomerRepository;
import com.api.webwork.security.utils.PasswordUtils;

@SpringBootApplication
//@ComponentScan("br.com.example.docker.controller.AuthenticationController")
public class DemoDockerSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDockerSpringBootApplication.class, args);
	}
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			Customer customerUser = new Customer();
			customerUser.setEmail("usuario@email.com");
			customerUser.setProfile(ProfileEnum.ROLE_USER);
			customerUser.setPassword(PasswordUtils.generateBCrypt("123456"));
			this.customerRepository.save(customerUser);
			
			Customer customerAdmin = new Customer();
			customerAdmin.setEmail("admin@email.com");
			customerAdmin.setProfile(ProfileEnum.ROLE_ADMIN);
			customerAdmin.setPassword(PasswordUtils.generateBCrypt("123456"));
			this.customerRepository.save(customerAdmin);
			
		};
	}
}
