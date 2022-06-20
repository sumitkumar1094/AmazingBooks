package com.amazingbooks.issuerms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazingbooks.issuerms.VO.IssueRequest;
import com.amazingbooks.issuerms.VO.IssueResponse;
import com.amazingbooks.issuerms.service.IssueService;

/**
 * 
 * @author sumit
 *
 */

@RestController
@RequestMapping("/issue")
public class IssueController {
	
	@Autowired
	IssueService issueService;
	
	@PostMapping
	private IssueResponse issue(@Valid @RequestBody IssueRequest request){
		return issueService.issue(request);
	}
}
