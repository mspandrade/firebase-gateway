package com.mspandrade.firebasegateway.data;

import lombok.Data;

@Data
public class UserInformation {

	private String uId;
	private String name;
	private String phoneNumber;
	private String email;
	private Boolean isEmailVerified;
	
	public UserInformation() {}

	public UserInformation(
			String uId,
			String name,
			String phoneNumber,
			String email,
			Boolean isEmailVerified
			) {
		super();
		this.uId = uId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.isEmailVerified = isEmailVerified;
	}
	
}
