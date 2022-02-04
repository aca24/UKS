package com.github.minigithub.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.github.minigithub.dto.IssueDTO;
import com.github.minigithub.mapper.IssueMapper;
import com.github.minigithub.model.Issue;
import com.github.minigithub.service.IssueService;

@RestController
@RequestMapping(value = "/api/issue", produces = MediaType.APPLICATION_JSON_VALUE)
public class IssueController {
	
	@Autowired
	private IssueService issueService;
	
	
	private IssueMapper issueMapper;
	
	
	
	
	public IssueController() {
		issueMapper = new IssueMapper();
	}



	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<IssueDTO>> getAll(){
		List<IssueDTO> issues = toIssueDTOList(issueService.findAll());		
		return new ResponseEntity<>(issues, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<IssueDTO> getById(@PathVariable Long id){
		Issue existingIssue = issueService.findById(id);
		if (existingIssue != null ){
			IssueDTO issueDTO = issueMapper.toDto(existingIssue);
			return new ResponseEntity<>(issueDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
				
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<IssueDTO> createIssue( @RequestBody IssueDTO issueDTO,@PathVariable Long id){
		Issue issue = issueService.create(issueMapper.toEntity(issueDTO), id);
		if(issue == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		issue.setDateCreated(new Date());
		return new ResponseEntity<>(issueMapper.toDto(issue), HttpStatus.CREATED);
	}
	
	
	 @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<IssueDTO> updateIssue(@RequestBody IssueDTO issueDTO, @PathVariable Long id){
		 Issue issue = issueService.updateTitle(issueMapper.toEntity(issueDTO), id);
		 if (issue == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 return new ResponseEntity<>(issueMapper.toDto(issue), HttpStatus.OK);
		 
	 }
	
	
	private List<IssueDTO> toIssueDTOList(List<Issue> list){
		List<IssueDTO> retVal = new ArrayList<IssueDTO> ();
		for(Issue entity: list) {
			IssueDTO dto = issueMapper.toDto(entity);

			retVal.add(dto);
		}
		
		return retVal;
		
	}

}
