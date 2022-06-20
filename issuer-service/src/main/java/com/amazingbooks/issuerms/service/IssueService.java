package com.amazingbooks.issuerms.service;

import com.amazingbooks.issuerms.VO.IssueRequest;
import com.amazingbooks.issuerms.VO.IssueResponse;

/**
 * 
 * @author sumit
 *
 */

public interface IssueService {
	
	public IssueResponse issue(IssueRequest request);
}
