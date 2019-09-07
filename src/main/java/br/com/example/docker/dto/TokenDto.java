package br.com.example.docker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TokenDto {
	
	public TokenDto() {
	}
	
	private String token;
	
	public TokenDto(String token) {
		this.token = token;
	}
	
}
