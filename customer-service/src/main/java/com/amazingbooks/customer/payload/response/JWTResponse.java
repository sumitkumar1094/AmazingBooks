package com.amazingbooks.customer.payload.response;

public class JWTResponse {
	
	private String token;
	private String type = "Bearer";
	private String emailId;
	
	public JWTResponse(String token, String emailId) {
		super();
		this.token = token;
		this.emailId = emailId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
