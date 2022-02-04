package com.github.minigithub.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.minigithub.model.Issue;
import com.github.minigithub.model.PullRequest;
import com.github.minigithub.repository.IssueRepository;
import com.github.minigithub.repository.PullRequestRepository;

@Service
public class IssueService {
	
	@Autowired
	private IssueRepository issueRepo;
	
	@Autowired
	private PullRequestService pullReqService;
	
	@Autowired
	private PullRequestRepository prRepo;
	
	public List<Issue> findAll(){
		return issueRepo.findAll();
	}

	
	public Issue findById(Long id) {
		return issueRepo.findById(id).orElse(null);
	}
	
	public Issue create(Issue entity, Long id) {
//		PullRequest pq = pullReqService.findById(158L);

		PullRequest pq = pullReqService.findById(id);
		ArrayList<PullRequest> prs = new ArrayList<>();
		prs.add(pq);
		entity.setPullRequests(prs);
		
		Collection<Issue> pullReqIssues = pq.getIssue();
		pullReqIssues.add(entity);
		
		
	 	try {
	 		//prRepo.saveAndFlush(pq);
			return issueRepo.saveAndFlush(entity);
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
