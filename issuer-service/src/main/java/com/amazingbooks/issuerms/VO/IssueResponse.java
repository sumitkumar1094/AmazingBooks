package com.amazingbooks.issuerms.VO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 
 * @author sumit
 *
 */

@AllArgsConstructor
@NoArgsConstructor
public class IssueResponse {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
