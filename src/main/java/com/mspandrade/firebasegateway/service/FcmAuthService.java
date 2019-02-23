package com.mspandrade.firebasegateway.service;

import org.springframework.stereotype.Service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import com.mspandrade.firebasegateway.data.UserInformation;

@Service
public class FcmAuthService {

	private static final Boolean CHECK_REVOKED = true;
	
	public UserInformation getUserInformation(String token) throws FirebaseAuthException {
		
		FirebaseAuth auth = getFirebaseAuth();
		FirebaseToken firebaseToken = auth.verifyIdToken(token, CHECK_REVOKED);
		
		UserRecord userRecord = auth.getUser(firebaseToken.getUid());
		
		return new UserInformation(
				userRecord.getUid(),
				userRecord.getDisplayName(),
				userRecord.getPhoneNumber(),
				userRecord.getEmail(),
				firebaseToken.isEmailVerified()
				);
	}
	
	private FirebaseAuth getFirebaseAuth() {
		return FirebaseAuth.getInstance();
	}
	
}
