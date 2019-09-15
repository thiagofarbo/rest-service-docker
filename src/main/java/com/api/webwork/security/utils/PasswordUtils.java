package com.api.webwork.security.utils;

import static java.util.Objects.isNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

	/**
	 * Generate a hash using o BCrypt.
	 * 
	 * @param password
	 * @return String
	 */
	public static String generateBCrypt(String password) {
		 if(isNull(password)) {
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
	public static boolean isValidPassword(String password, String passwordEncoded) {
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.matches(password, passwordEncoded);
	}

}
