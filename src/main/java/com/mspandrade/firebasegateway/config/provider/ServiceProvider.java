package com.mspandrade.firebasegateway.config.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.mspandrade.firebasegateway.config.DefaultUser;
import com.mspandrade.firebasegateway.service.ClientUserDetail;
import com.mspandrade.firebasegateway.service.UserService;

@Configuration
public class ServiceProvider {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DefaultUser defaultUser;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new ClientUserDetail(userService, defaultUser);
	}
	
}
