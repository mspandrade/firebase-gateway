package com.mspandrade.firebasegateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mspandrade.firebasegateway.data.StoreUserRequestData;
import com.mspandrade.firebasegateway.model.User;
import com.mspandrade.firebasegateway.service.UserService;

@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("users")
	public User store(@Validated @RequestBody StoreUserRequestData user) {
		return userService.save(user);
	}
	
}
