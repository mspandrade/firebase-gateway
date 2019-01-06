package com.mspandrade.firebasegateway.data;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;

import com.google.firebase.database.annotations.NotNull;

import lombok.Data;

@Data
public class TopicMessageData {
	
	@NotBlank
	private String topicName;
	
	private Map<String, String> data = new HashMap<>();
	
	@NotNull
	private NotificationData notificationData;

}
