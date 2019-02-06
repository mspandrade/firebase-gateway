package com.mspandrade.firebasegateway.data.reponse;

import lombok.Data;

@Data
public class ValidateUserTokenResponse {

	private String uId;
	
	public ValidateUserTokenResponse() {}

	public ValidateUserTokenResponse(String uId) {
		super();
		this.uId = uId;
	}
	
}
