package br.com.example.docker.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.example.docker.model.Customer;
import br.com.example.docker.repository.CustomerRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		List<Customer> customers = this.customerRepository.findAll();
		
		if(!customers.isEmpty()) {
			this.buildCustomer(1L, "Thiago", "Av. Brg. Faria Lima, 3477 - Itaim Bibi, São Paulo");
		}
		
	}
	
	public void buildCustomer(Long id, String name,String phone) {
		
		Customer customer = new Customer(id, name, phone);
		
		 this.customerRepository.save(customer);
			
		
	}

}
