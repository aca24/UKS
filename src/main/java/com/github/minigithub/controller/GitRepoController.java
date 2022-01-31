package com.github.minigithub.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.minigithub.dto.GitRepoDTO;
import com.github.minigithub.dto.IssueDTO;
import com.github.minigithub.dto.PullRequestDTO;
import com.github.minigithub.mapper.GitRepoMapper;
import com.github.minigithub.model.GitRepo;
import com.github.minigithub.model.Issue;
import com.github.minigithub.model.PullRequest;
import com.github.minigithub.service.GitRepoService;

@RestController
@RequestMapping(value = "/api/gitRepo", produces = MediaType.APPLICATION_JSON_VALUE)
public class GitRepoController {
	
	@Autowired
	GitRepoService gitRepoService;
	
	GitRepoMapper gitRepoMapper;
	
	
	
	public GitRepoController() {
		gitRepoMapper = new GitRepoMapper();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<GitRepoDTO>> getAll(){
		List<GitRepoDTO> gitRepos = toGitRepoDTOList(gitRepoService.findAll());
		
		return new ResponseEntity<>(gitRepos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<GitRepoDTO> getById(@PathVariable Long id){
		GitRepo existingGitRepo = gitRepoService.findById(id);
		if (existingGitRepo == null ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		GitRepoDTO gitRepoDTO = gitRepoMapper.toDto(existingGitRepo);
		return new ResponseEntity<>(gitRepoDTO, HttpStatus.OK);
				
	}
	
	@PostMapping
	public ResponseEntity<GitRepoDTO> createGitRepo( @RequestBody GitRepoDTO gitRepoDTO){
		GitRepo gitRepo = gitRepoService.create(gitRepoMapper.toEntity(gitRepoDTO));
		if(gitRepo == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(gitRepoMapper.toDto(gitRepo), HttpStatus.CREATED);
	}
	
	

	private List<GitRepoDTO> toGitRepoDTOList(List<GitRepo> list){
		List<GitRepoDTO> retVal = new ArrayList<GitRepoDTO> ();
		for(GitRepo entity: list) {
			GitRepoDTO dto = gitRepoMapper.toDto(entity);

			retVal.add(dto);
		}
		
		return retVal;
		
	}

}
