package com.mspandrade.firebasegateway.data;

import javax.validation.constraints.NotEmpty;

import com.google.firebase.database.annotations.NotNull;

import lombok.Data;

@Data
public class NotificationData {

	@NotEmpty
	@NotNull
	private String title;
	
	@NotEmpty
	@NotNull
	private String body;
	
}
