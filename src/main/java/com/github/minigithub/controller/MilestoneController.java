package com.github.minigithub.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.minigithub.dto.MilestoneDTO;
import com.github.minigithub.service.MilestoneService;

@RestController
@RequestMapping(value = "/api/milestone", produces = MediaType.APPLICATION_JSON_VALUE)
public class MilestoneController {

	@Autowired
	private MilestoneService milestoneService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MilestoneDTO>> getAll(){
		List<MilestoneDTO> milestones = milestoneService.findAll();
		
		return new ResponseEntity<>(milestones, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<MilestoneDTO> getMilestone(@PathVariable Long id){
		MilestoneDTO retVal = milestoneService.findById(id);
		if (retVal == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<MilestoneDTO> addNew(@RequestBody MilestoneDTO milestone){
		MilestoneDTO created = milestoneService.create(milestone);
		if(created == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(created, HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<MilestoneDTO> editMilestone(@RequestBody MilestoneDTO milestone){
		MilestoneDTO updated = milestoneService.update(milestone);
		if(updated == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteMilestone(@PathVariable Long id){
		try {
			milestoneService.delete(id);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
