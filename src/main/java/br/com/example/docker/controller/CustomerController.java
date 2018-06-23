package br.com.example.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/docker")
public class CustomerController {
	
	@GetMapping("/customer")
	public String getCustomer() {
		return "Hi Customer";
	}
	
}
