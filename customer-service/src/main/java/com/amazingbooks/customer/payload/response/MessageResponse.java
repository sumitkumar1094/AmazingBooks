package com.amazingbooks.customer.payload.response;

/**
 * 
 * @author sumit
 *
 */
public class MessageResponse {
	
	public MessageResponse(String message) {
		super();
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
