/**
 * @author thiagoemidio
 */


package com.api.webwork.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.api.webwork.enums.ProfileEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customers")
public class Customer implements Serializable{

	private static final long serialVersionUID = -1740992881331522235L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String address;
	
	private String phone;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "customer_role",
//	joinColumns = @JoinColumn(name = "customer_id"),
//	inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private List<Roles> roles;
	
	private ProfileEnum profile;
	
	public Customer(Customer customer) {
		super();
		this.name = customer.getName();
		this.email = customer.getEmail();
		this.address =  customer.getAddress();
		this.phone = customer.getPhone();
//		this.roles = customer.getRoles();
		this.password = customer.getPassword();
	}
	
	public Customer(String name, String email, String password, String address, String phone) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone = phone;
	}
}