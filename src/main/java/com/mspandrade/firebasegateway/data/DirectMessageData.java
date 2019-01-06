package com.mspandrade.firebasegateway.data;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;

import com.google.firebase.database.annotations.NotNull;

import lombok.Data;

@Data
public class DirectMessageData {

	@NotBlank
	private String clientToken;
	
	private Map<String, String> data = new HashMap<>();
	
	@NotNull
	private NotificationData notificationData;
	
}
