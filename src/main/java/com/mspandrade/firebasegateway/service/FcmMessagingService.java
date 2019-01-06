package com.mspandrade.firebasegateway.service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidConfig.Priority;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.ApnsConfig;
import com.google.firebase.messaging.Aps;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.mspandrade.firebasegateway.data.DirectMessageData;
import com.mspandrade.firebasegateway.data.NotificationData;
import com.mspandrade.firebasegateway.data.TopicMessageData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FcmMessagingService {
	
	private static final Long DURATION = Duration.ofMinutes(2).toMillis();
	private static final String PERSONAL_CATEGORY = "personal";
	
	public void sendMessage(TopicMessageData topicMessageData) throws InterruptedException, ExecutionException {
		
		String response = FirebaseMessaging.getInstance()
	    		.sendAsync(buildMessage(topicMessageData))
	    		.get();
	    
	    log.error(response);
	}

	public void sendMessage(DirectMessageData directMessageData) throws InterruptedException, ExecutionException {
	    
	    String response = FirebaseMessaging.getInstance()
	    		.sendAsync(buildMessage(directMessageData))
	    		.get();
	    
	    log.error(response);
	}
	
	private Notification mapToNotification(NotificationData data) {
		
		return new Notification(data.getTitle(), data.getBody());
	}
	
	private AndroidConfig buildAndroidConfig(String collapseKey, Priority priority) {
		
		return AndroidConfig.builder()
		        .setTtl(DURATION)
		        .setCollapseKey(collapseKey)
		        .setPriority(priority)
		        .setNotification(
		        		AndroidNotification.builder().setTag(collapseKey).build()
		        		)
		        .build();
	}
	
	private ApnsConfig buildApnsConfig(String category, String threadId) {
		
		return ApnsConfig.builder().setAps(
				
				Aps.builder()
					.setCategory(category)
					.setThreadId(threadId)
					.build()
					
			).build();
	}
	
	private Message.Builder buildMessage(Map<String, String> data, Notification notification) {
		
		AndroidConfig androidConfig = buildAndroidConfig(PERSONAL_CATEGORY, Priority.HIGH);
		
		ApnsConfig apnsConfig = buildApnsConfig(PERSONAL_CATEGORY, PERSONAL_CATEGORY);
		
		return Message.builder()
				.putAllData(data)
		        .setApnsConfig(apnsConfig)
		        .setAndroidConfig(androidConfig)
		        .setNotification(notification);
	}
	
	private Message buildMessage(DirectMessageData dataMessage) {
		
		return buildMessage(dataMessage.getData(), mapToNotification(dataMessage.getNotificationData()))
				.setToken(dataMessage.getClientToken())
				.build();
	}
	
	private Message buildMessage(TopicMessageData dataMessage) {
		
		return buildMessage(
				
					dataMessage.getData(), 
					mapToNotification(dataMessage.getNotificationData())
					
				).setTopic(dataMessage.getTopicName())
				.build();
	}
	
}
