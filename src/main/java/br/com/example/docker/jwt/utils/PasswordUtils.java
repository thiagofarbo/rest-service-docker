package br.com.example.docker.jwt.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

	/**
	 * Generate a hash using o BCrypt.
	 * 
	 * @param password
	 * @return String
	 */
	public static String gerarBCrypt(String password) {
		if (password == null) {
			return password;
		}

		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.encode(password);
	}

	/**
	 * Verify if the password valid.
	 * 
	 * @param password
	 * @param passwordEncoded
	 * @return boolean
	 */
	public static boolean senhaValida(String password, String passwordEncoded) {
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.matches(password, passwordEncoded);
	}

}
