package com.github.minigithub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.minigithub.model.GitRepo;
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
	

	

}
