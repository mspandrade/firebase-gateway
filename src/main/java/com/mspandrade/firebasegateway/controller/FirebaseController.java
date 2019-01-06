package com.mspandrade.firebasegateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mspandrade.firebasegateway.data.DirectMessageData;
import com.mspandrade.firebasegateway.data.TopicMessageData;
import com.mspandrade.firebasegateway.service.FcmMessagingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api")
@Slf4j
public class FirebaseController {

	private FcmMessagingService fcmMessagingService;
	
	@Autowired
	public FirebaseController(FcmMessagingService fcmMessagingService) {
		this.fcmMessagingService = fcmMessagingService;
	}
	
	@PostMapping("messages")
	public ResponseEntity<Object> sendDirectMessage(@Validated @RequestBody DirectMessageData directMessageData) {
		
		ResponseEntity<Object> response = null;
		
		try {
			
			fcmMessagingService.sendMessage(directMessageData);
			
			response = ResponseEntity.ok().build();
			
		} catch (Exception e) {
			
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
			log.info("ERRO AO ENVIAR MENSAGEM DIRETA PARA " + directMessageData.getClientToken(), e);
		}
		
		return response;
	}
	
	@PostMapping("topics") 
	public ResponseEntity<Object> sendTopicMessage(@Validated @RequestBody TopicMessageData topicMessageData){
		
		ResponseEntity<Object> response = null;
		
		try {
			
			fcmMessagingService.sendMessage(topicMessageData);
			
			response = ResponseEntity.ok().build();
			
		} catch (Exception e) {
			
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
			log.info("ERRO AO ENVIAR TOPICO DE NOME " + topicMessageData.getTopicName(), e);
		}
		
		return response;
	}
	
}
