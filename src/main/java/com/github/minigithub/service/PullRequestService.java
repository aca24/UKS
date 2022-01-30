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
	
	public PullRequest create(PullRequest entity) throws Exception {
		 	PullRequest pReq = pullReqRepo.save(entity);
		 	System.out.println(pReq);
	        return pReq ;
	        

	}

	
	public void deleteById(Long id) throws Exception {
		PullRequest existing = pullReqRepo.findById(id).orElse(null);
		if(existing != null) {
			pullReqRepo.deleteById(id);
		}else {
			throw new Exception("Pull request with given id doesn't exist");
		}
	}

	public PullRequest findById(Long id) {
		return this.pullReqRepo.findById(id).orElse(null);
	}


	public PullRequest updateName(PullRequest entity, Long id) throws Exception {
		PullRequest existingPullReq = pullReqRepo.findById(id).orElse(null);
		if(existingPullReq == null) {
			throw new Exception("Pull request with given id does not exist!");
		}
		existingPullReq.setName(entity.getName());	
		
		return pullReqRepo.save(existingPullReq);
	}

	
	
}
