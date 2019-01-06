package com.mspandrade.firebasegateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.mspandrade.firebasegateway.model.User;

import lombok.Data;

@Data
@Component
public class DefaultUser {
	
	@Value("${defaultuser.enabled}")
	private Boolean enabled;
	
	@Value("${defaultuser.username}")
	private String username;
	
	@Value("${defaultuser.password}")
	private String password;
	
	@Value("${defaultuser.email}")
	private String email;
	
	private PasswordEncoder passwordEncoder;	
	
	@Autowired
	public DefaultUser(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	public Boolean isEnabled() {
		return enabled;
	}
	
	public User instanceDefaultUser() {
		return new User(
				username, 
				email, 
				passwordEncoder.encode(password)
				);
	}
	
}
