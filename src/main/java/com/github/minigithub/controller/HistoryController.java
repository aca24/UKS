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

import com.github.minigithub.dto.HistoryDTO;
import com.github.minigithub.service.HistoryService;

@RestController
@RequestMapping(value = "/api/history", produces = MediaType.APPLICATION_JSON_VALUE)
public class HistoryController {

	@Autowired
	private HistoryService historyService;
	
	@RequestMapping(value = "/search/{input}", method = RequestMethod.GET)
 	public ResponseEntity<List<HistoryDTO>> searchByUsername(@PathVariable String input){
 		
         List<HistoryDTO> retVal = historyService.searchByComment(input);
 		
 		return new ResponseEntity<>(retVal, HttpStatus.OK);
 	}
	
	@RequestMapping( method = RequestMethod.POST)
 	public ResponseEntity<HistoryDTO> searchByUsername(@RequestBody HistoryDTO input){
 		
         HistoryDTO saved = historyService.save(input);
 		if(saved == null)
 			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
 		return new ResponseEntity<>(saved, HttpStatus.OK);
 	}
	
	
}
