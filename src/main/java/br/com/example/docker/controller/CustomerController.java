/**
 * @author thiagoemidio
 */

package br.com.example.docker.controller;

import java.util.List;
import br.com.example.docker.model.Customer;
import br.com.example.docker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/docker")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	@ResponseBody
	public List<Customer> getCustomer() {

		return this.customerService.getAllCustomers();
	}
}
