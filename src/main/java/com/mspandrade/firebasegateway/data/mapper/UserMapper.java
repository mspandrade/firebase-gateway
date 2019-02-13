package com.mspandrade.firebasegateway.data.mapper;

import com.mspandrade.firebasegateway.data.StoreUserRequestData;
import com.mspandrade.firebasegateway.model.User;

public class UserMapper {
	
	private UserMapper() {} 
	
	public static User toModel(StoreUserRequestData dto) {
		return new User(dto.getUsername(), dto.getEmail(), dto.getPassword());
	}

}
