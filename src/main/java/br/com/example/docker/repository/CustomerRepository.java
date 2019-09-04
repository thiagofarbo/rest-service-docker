/**
 * @author thiagoemidio
 */


package br.com.example.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.example.docker.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	Customer findByEmail(String username);

}
