package com.mspandrade.firebasegateway.data;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotEmpty;

import com.google.firebase.database.annotations.NotNull;

import lombok.Data;

@Data
public class DirectMessageData {

	@NotEmpty
	@NotNull
	private String clientToken;
	
	private Map<String, String> data = new HashMap<>();
	
	@NotNull
	private NotificationData notificationData;
	
}
