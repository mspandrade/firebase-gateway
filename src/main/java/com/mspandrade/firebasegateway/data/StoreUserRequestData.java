package com.mspandrade.firebasegateway.data;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class StoreUserRequestData {
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
}
