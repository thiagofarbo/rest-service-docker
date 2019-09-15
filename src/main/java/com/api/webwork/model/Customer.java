/**
 * @author thiagoemidio
 */


package com.api.webwork.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.api.webwork.enums.ProfileEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="customer")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable{

	private static final long serialVersionUID = -1740992881331522235L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "adrress")
	private String adrress;
	
	@Column(name = "phone")
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
		this.adrress =  customer.getAdrress();
		this.phone = customer.getPhone();
//		this.roles = customer.getRoles();
		this.password = customer.getPassword();
	}
	
	public Customer(Long id, String name, String email, String password, String adrress, String phone) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.adrress = adrress;
		this.phone = phone;
	}
	
	public Customer(String name, String email, String password, String adrress, String phone /*,List<Roles> roles*/) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.adrress = adrress;
		this.phone = phone;
//		this.roles = roles;
	}
}	
