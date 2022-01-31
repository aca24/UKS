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

import com.github.minigithub.dto.LabelDTO;
import com.github.minigithub.service.LabelService;

@RestController
@RequestMapping(value = "/api/label", produces = MediaType.APPLICATION_JSON_VALUE)
public class LabelController {

	@Autowired
	private LabelService labelService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LabelDTO>> getAll(){
		List<LabelDTO> labels = labelService.findAll();
		
		return new ResponseEntity<>(labels, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<LabelDTO> getLabel(@PathVariable Long id){
		LabelDTO retVal = labelService.findById(id);
		if (retVal == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<LabelDTO> addNew(@RequestBody LabelDTO label){
		LabelDTO created = labelService.create(label);
		if(created == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(created, HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<LabelDTO> editLabel(@RequestBody LabelDTO label){
		LabelDTO updated = labelService.update(label);
		if(updated == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteLabel(@PathVariable Long id){
		try {
			labelService.delete(id);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
