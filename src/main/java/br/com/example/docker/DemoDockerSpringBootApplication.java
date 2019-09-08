package br.com.example.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import br.com.example.docker.enums.ProfileEnum;
import br.com.example.docker.jwt.utils.PasswordUtils;
import br.com.example.docker.model.Customer;
import br.com.example.docker.repository.CustomerRepository;

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
			customerUser.setEmail("thiagofarbo@gmail.com");
			customerUser.setProfile(ProfileEnum.ROLE_USER);
			customerUser.setPassword(PasswordUtils.generateBCrypt("@123456"));
			this.customerRepository.save(customerUser);
			
			Customer customerAdmin = new Customer();
			customerAdmin.setEmail("thiagofarbo@gmail.com");
			customerAdmin.setProfile(ProfileEnum.ROLE_ADMIN);
			customerAdmin.setPassword(PasswordUtils.generateBCrypt("@123456"));
			this.customerRepository.save(customerAdmin);
			
		};
	}
}
