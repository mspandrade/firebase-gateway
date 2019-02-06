package com.mspandrade.firebasegateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuthException;
import com.mspandrade.firebasegateway.data.DirectMessageData;
import com.mspandrade.firebasegateway.data.TopicMessageData;
import com.mspandrade.firebasegateway.data.ValidateUserToken;
import com.mspandrade.firebasegateway.data.reponse.ValidateUserTokenResponse;
import com.mspandrade.firebasegateway.service.FcmAuthService;
import com.mspandrade.firebasegateway.service.FcmMessagingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api")
@Slf4j
public class FirebaseController {

	private FcmMessagingService fcmMessagingService;
	private FcmAuthService fcmAuthService;
	
	@Autowired
	public FirebaseController(
			FcmMessagingService fcmMessagingService,
			FcmAuthService fcmAuthService
			) {
		this.fcmMessagingService = fcmMessagingService;
		this.fcmAuthService = fcmAuthService;
	}
	
	@PostMapping("messages")
	public ResponseEntity<Object> sendDirectMessage(@Validated @RequestBody DirectMessageData directMessageData) {
		
		ResponseEntity<Object> response = null;
		
		try {
			
			fcmMessagingService.sendMessage(directMessageData);
			
			response = ResponseEntity.ok().build();
			
		} catch (Exception e) {
			
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
			log.error("ERRO AO ENVIAR MENSAGEM DIRETA PARA " + directMessageData.getClientToken(), e);
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
			
			log.error("ERRO AO ENVIAR TOPICO DE NOME " + topicMessageData.getTopicName(), e);
		}
		
		return response;
	}
	
	@PostMapping("auth/validate")
	public ResponseEntity<Object> validateUserToken(@RequestBody ValidateUserToken userToken) {
		
		ResponseEntity<Object> response = null;
		
		try {
			
			ValidateUserTokenResponse responseData;
			
			responseData = new ValidateUserTokenResponse(
					fcmAuthService.getUid(userToken.getClientToken())
					);
			
			response = ResponseEntity.ok().body(responseData);
			
		} catch (FirebaseAuthException e) {
			
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
			log.error("TOKEN INVALIDO " + userToken.getClientToken(), e);
			
		}  catch (Exception e) {
			
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
			log.error("ERRO AO VALIDAR " + userToken.getClientToken(), e);
		}
		
		
		return response;
	}
	
}
