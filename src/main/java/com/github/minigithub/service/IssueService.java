package com.github.minigithub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.minigithub.model.Issue;
import com.github.minigithub.model.PullRequest;
import com.github.minigithub.repository.IssueRepository;

@Service
public class IssueService {
	
	@Autowired
	private IssueRepository issueRepo;
	
	public List<Issue> findAll(){
		return issueRepo.findAll();
	}

	
	public Issue findById(Long id) {
		return issueRepo.findById(id).orElse(null);
	}
	
	public Issue create(Issue entity) {
	 	try {
			return issueRepo.save(entity);
		} catch (Exception e) {
			return null;
		}
	}
	 	
	public Issue updateTitle(Issue entity, Long id) {
		Issue existingIssue = issueRepo.findById(id).orElse(null);
		if(existingIssue == null) 	return null; 
		try {
			existingIssue.setTitle(entity.getTitle());
			return issueRepo.save(existingIssue);
		} catch (Exception e) {
			return null;
		}
		
	}
	        	


}
