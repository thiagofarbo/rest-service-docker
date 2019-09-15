package com.api.webwork.security.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtils {
	
	public static final String CLAIM_KEY_USERNAME = "sub";
	public static final String CLAIM_KEY_ROLE = "role";
	public static final String CLAIM_KEY_CREATED = "created";
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	public String getCustomerByToken(String token) {
		
		String username;
		
		try {
			
			Claims claims = getClaimsByToken(token);
			username = claims.getSubject();
			
		}catch (Exception e) {
			username = null;
		}
		return username;
	}
	
	public Date getExpirationDateByToken(String token) {
		
		Date expiration;
		
		try {
				Claims claims = getClaimsByToken(token);
				expiration = claims.getExpiration();
		}catch (Exception e) {
		
			expiration = null;
		}
		
		return expiration;
		
	}
	
	public String refreshToken(String token) {
		
		String refreshedToken;
		
		try {
			Claims claims = getClaimsByToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			refreshedToken = generateToken(claims);
			
		}catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}
	
	public boolean isValidToken(String token) {
		
		return !isExpiredToken(token);
	}
	
	public String getToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
		userDetails.getAuthorities().forEach(authority -> claims.put(CLAIM_KEY_ROLE, authority.getAuthority()));
		claims.put(CLAIM_KEY_CREATED, new Date());

		return generateToken(claims);
	}

	/**
	 * Realiza o parse do token JWT para extrair as informações contidas no corpo
	 * dele.
	 * 
	 * @param token
	 * @return Claims
	 */
	private Claims getClaimsByToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	/**
	 * Retorna a data de expiração com base na data atual.
	 * 
	 * @return Date
	 */
	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + expiration * 1000);
	}

	/**
	 * Verifica se um token JTW está expirado.
	 * 
	 * @param token
	 * @return boolean
	 */
	private boolean isExpiredToken(String token) {
		Date dataExpiracao = this.getExpirationDateByToken(token);
		if (dataExpiracao == null) {
			return false;
		}
		return dataExpiracao.before(new Date());
	}

	/**
	 * Gera um novo token JWT contendo os dados (claims) fornecidos.
	 * 
	 * @param claims
	 * @return String
	 */
	private String generateToken(Map<String, Object> claims) {
		return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate())
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	
	
}
