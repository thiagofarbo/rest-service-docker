package br.com.example.docker.model;

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

//import org.springframework.security.core.GrantedAuthority;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Roles /*implements GrantedAuthority*/{
	
	
	private static final long serialVersionUID = 5052747395527611366L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Roles> roles;
	
//	@Override
//	public String getAuthority() {
//		return this.name;
//	}

}
