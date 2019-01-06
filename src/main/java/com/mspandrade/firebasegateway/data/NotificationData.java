package com.mspandrade.firebasegateway.data;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class NotificationData {

	@NotBlank
	private String title;
	
	@NotBlank
	private String body;
	
}
