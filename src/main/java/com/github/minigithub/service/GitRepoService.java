package com.github.minigithub.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.minigithub.model.Branch;
import com.github.minigithub.model.GitRepo;
import com.github.minigithub.model.Issue;
import com.github.minigithub.model.Project;
import com.github.minigithub.model.PullRequest;
import com.github.minigithub.repository.GitRepoRepository;

@Service
public class GitRepoService {
	
	@Autowired
	GitRepoRepository gitRepoRepository;
	
	public List<GitRepo> findAll(){
		return gitRepoRepository.findAll();
	}
	
	public GitRepo findById(Long id) {
		return gitRepoRepository.findById(id).orElse(null);
	}
	
	public GitRepo create(GitRepo entity) {
		entity.setBranch(new ArrayList<Branch>());
		entity.setProjects(new ArrayList<Project>());
	 	try {
			return gitRepoRepository.save(entity);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public GitRepo updateName(GitRepo entity, Long id) {
		GitRepo existingGitRepo = gitRepoRepository.findById(id).orElse(null);
		if(existingGitRepo == null) 	return null; 
		try {
			existingGitRepo.setName(entity.getName());
			return gitRepoRepository.save(existingGitRepo);
		} catch (Exception e) {
			return null;
		}
		
	}
	

	

}
