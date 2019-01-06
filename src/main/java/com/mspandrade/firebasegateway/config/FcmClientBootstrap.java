package com.mspandrade.firebasegateway.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FcmClientBootstrap {
	

	public FcmClientBootstrap(
			@Value("${firebase.adminSdk.fileName}") String adminSdkFile
			) {
	    init(adminSdkFile);
	}
	
	public void init(String adminSdkFile) {
		
		String file = getClass().getClassLoader().getResource(adminSdkFile).getFile();
		
	    try (InputStream serviceAccount = new FileInputStream(file)) {
	    	
	      FirebaseOptions options = new FirebaseOptions.Builder()
	          .setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
	
	      FirebaseApp.initializeApp(options);
	    }
	    catch (IOException e) {
	      log.error("ERROR INIT SERVICE", e);
	    }
	}
	
}
