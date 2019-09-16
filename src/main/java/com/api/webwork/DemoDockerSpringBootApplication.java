package com.api.webwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DemoDockerSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDockerSpringBootApplication.class, args);
	}
	
//	@Autowired
//	private CustomerRepository customerRepository;
//	
//	
//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
//			
//			Customer customerUser = new Customer();
//			customerUser.setEmail("usuario@email.com");
//			customerUser.setProfile(ProfileEnum.ROLE_USER);
//			customerUser.setPassword(PasswordUtils.generateBCrypt("123456"));
//			
//			Customer customer = customerRepository.findByEmail(customerUser.getEmail());
//			
//			if(customer == null) {
//				
//				this.customerRepository.save(customerUser);
//			}
//			System.out.println("Finding customer by email");
//			System.out.println(customerRepository.findByEmail("usuario@email.com"));
//			
//			
//			Customer customerAdmin = new Customer();
//			customerAdmin.setEmail("admin@email.com");
//			customerAdmin.setProfile(ProfileEnum.ROLE_ADMIN);
//			customerAdmin.setPassword(PasswordUtils.generateBCrypt("123456"));
//			
//			Customer customer2 = customerRepository.findByEmail(customerAdmin.getEmail());
//			
//			if(customer2 == null) {
//				
//				this.customerRepository.save(customerAdmin);
//			}
//			
//			
//			customerRepository.findAll().forEach(System.out::println);
//			
//			System.out.println("Finding customer by email");
//			System.out.println(customerRepository.findByEmail("admin@email.com"));
//			
//		};
//	}
}
