package com.github.minigithub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.minigithub.model.PullRequest;
import com.github.minigithub.repository.PullRequestRepository;

@Service
public class PullRequestService {
	
	@Autowired
	private PullRequestRepository pullReqRepo;
	
	public List<PullRequest> findAll(){
		return pullReqRepo.findAll();
	}
	
	public PullRequest create(PullRequest entity) {
		try {
			return pullReqRepo.save(entity);
		} catch (Exception e) {
			return null;
		}
	}

	
	public boolean deleteById(Long id) {
		PullRequest existing = pullReqRepo.findById(id).orElse(null);
		if(existing != null) {
			pullReqRepo.deleteById(id);
			return true;
		}else {
			return false;
			//throw new Exception("Pull request with given id doesn't exist");
		}
	}

	public PullRequest findById(Long id) {
		return this.pullReqRepo.findById(id).orElse(null);
	}


	public PullRequest updateName(PullRequest entity, Long id) {
		PullRequest existingPullReq = pullReqRepo.findById(id).orElse(null);
		if(existingPullReq == null) return null;
		try {
			existingPullReq.setName(entity.getName());	
			return pullReqRepo.save(existingPullReq);
		} catch (Exception e) {
			return null;
		}
		
	}

	
	
}
