/**
 * @author thiagoemidio
 */

package br.com.example.docker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.docker.model.Customer;
import br.com.example.docker.service.CustomerService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@ResponseBody
//	@Secured({"ROLE_ADMIN"})
	@GetMapping("/v1/customers")
	public Page<Customer> getCustomer(@RequestParam(defaultValue = "0") final int page, @RequestParam(defaultValue = "50") final int size) {
		return this.customerService.getAllCustomers(page, size);
	}
	
	@ResponseBody
//	@Secured({"ROLE_ADMIN"})
	@GetMapping("/v2/customers")
	public Page<Customer> getCustomerV2(@RequestParam(defaultValue = "0") final int page, @RequestParam(defaultValue = "50") final int size) {
		return this.customerService.getAllCustomers(page, size);
	}
	
	@ResponseBody
//	@Secured({"ROLE_ADMIN"})
	@GetMapping(value = "/customers", headers = "X-API-Version=v1")
	public Page<Customer> getCustomerHeaderV1(@RequestParam(defaultValue = "0") final int page, @RequestParam(defaultValue = "50") final int size) {
		return this.customerService.getAllCustomers(page, size);
	}
	
	@ResponseBody
//	@Secured({"ROLE_ADMIN"})
	@GetMapping(value = "/customers", headers = "X-API-Version=v2")
	public Page<Customer> getCustomerHeaderV2(@RequestParam(defaultValue = "0") final int page, @RequestParam(defaultValue = "50") final int size) {
		return this.customerService.getAllCustomers(page, size);
	}
}
