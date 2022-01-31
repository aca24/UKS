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

import com.github.minigithub.dto.PullRequestDTO;
import com.github.minigithub.mapper.PullRequestMapper;
import com.github.minigithub.model.PullRequest;
import com.github.minigithub.service.PullRequestService;


@RestController
@RequestMapping(value = "/api/pullReq", produces = MediaType.APPLICATION_JSON_VALUE)
public class PullRequestController {

	@Autowired
	private PullRequestService pullReqService;
	
	private PullRequestMapper pullReqMapper;
	
	
	public PullRequestController() {
		pullReqMapper = new PullRequestMapper();
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PullRequestDTO>> getAll(){
		List<PullRequestDTO> pulReqs = toPullReqDTOList(pullReqService.findAll());
		
		return new ResponseEntity<>(pulReqs, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<PullRequestDTO> getById(@PathVariable Long id){
		PullRequest existingPullReq = pullReqService.findById(id);
		if (existingPullReq != null ){
			PullRequestDTO pulReqDTO = pullReqMapper.toDto(existingPullReq);
			return new ResponseEntity<>(pulReqDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
				
	}
	
	@PostMapping
	public ResponseEntity<PullRequestDTO> createPullRequest( @RequestBody PullRequestDTO pullReqDTO){
		
		PullRequest pullReq = pullReqService.create(pullReqMapper.toEntity(pullReqDTO));
		if(pullReq == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(pullReqMapper.toDto(pullReq), HttpStatus.CREATED);
		}

	
	@RequestMapping(value = "/{pullReqId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePullRequest(@PathVariable Long pullReqId){
		if(pullReqService.deleteById(pullReqId)) return new ResponseEntity<>(HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

	
	 @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<PullRequestDTO> updatePullRequest(@RequestBody PullRequestDTO pullReqDTO, @PathVariable Long id){
		 PullRequest pullReq = pullReqService.updateName(pullReqMapper.toEntity(pullReqDTO), id);
		 if (pullReq == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 return new ResponseEntity<>(pullReqMapper.toDto(pullReq), HttpStatus.OK);
		 
	 }

	
	
	
	private List<PullRequestDTO> toPullReqDTOList(List<PullRequest> list){
		List<PullRequestDTO> retVal = new ArrayList<PullRequestDTO> ();
		for(PullRequest entity: list) {
			PullRequestDTO dto = pullReqMapper.toDto(entity);
			//PullRequestDTO dto = new PullRequestDTO();

			retVal.add(dto);
		}
		
		return retVal;
		
	}
	
}
