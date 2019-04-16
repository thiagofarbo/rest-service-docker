/**
 * @author thiagoemidio
 */


package br.com.example.docker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	@Column(name = "IdCustomer")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "adrress")
	private String adrress;
	
	@Column(name = "phone")
	private String phone;
	
}	
