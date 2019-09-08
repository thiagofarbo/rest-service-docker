package br.com.example.docker.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtAuthenticationDto {
	
	public JwtAuthenticationDto() {
	}

	@NotEmpty(message = "E-mail must not be empty")
	@Email(message = "E-mail invalid")
	private String email;
	
	@NotEmpty(message = "Password must not be empty")
	private String password;
	
	@Override
	public String toString() {
		return "JwtAuthenticationRequestDto [email=" + email + ", password=" + password + "]";
	}
	
}
