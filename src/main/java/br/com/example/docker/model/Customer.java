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

@Entity(name="customer")
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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdrress() {
		return adrress;
	}
	public void setAdrress(String adrress) {
		this.adrress = adrress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", adrress=" + adrress + ", phone=" + phone + "]";
	}
}	
