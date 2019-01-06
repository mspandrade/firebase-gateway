package com.mspandrade.firebasegateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mspandrade.firebasegateway.model.User;
import com.mspandrade.firebasegateway.repository.UserRepository;

@Service
public class UserService {

	private PasswordEncoder passwordEncoder;	
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public User save(User user) {		
		
		if(!isEncodedPassword(user)) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		
		userRepository.save(user);		
		return user;
	}
	
	public boolean isEncodedPassword(User user) {
		
		if(user.getId() == null) {
			return false;
		}		
		User oldUser = userRepository.findOne(user.getId());		
		return passwordEncoder.matches(user.getPassword(), oldUser.getPassword());
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
}
