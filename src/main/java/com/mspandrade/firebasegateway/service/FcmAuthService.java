package com.mspandrade.firebasegateway.service;

import org.springframework.stereotype.Service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

@Service
public class FcmAuthService {

	private static Boolean CHECK_REVOKED= true;
	
	public String getUid(String token) throws FirebaseAuthException {
		
		return getFirebaseAuth().verifyIdToken(token, CHECK_REVOKED).getUid();
	}
	
	private FirebaseAuth getFirebaseAuth() {
		return FirebaseAuth.getInstance();
	}
	
}
