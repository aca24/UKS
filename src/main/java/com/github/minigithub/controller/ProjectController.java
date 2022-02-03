package com.github.minigithub.controller;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.minigithub.dto.ProjectDTO;
import com.github.minigithub.dto.UserDTO;
import com.github.minigithub.model.User;
import com.github.minigithub.service.ProjectService;

@RestController
@RequestMapping(value = "/api/project", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<ProjectDTO>> getAll(){
		Collection<ProjectDTO> projects = projectService.findAll();
		
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/my", method = RequestMethod.GET)
	public ResponseEntity<Collection<ProjectDTO>> getMyProjects(){
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = ((User) currentUser.getPrincipal()).getEmail();
        Collection<ProjectDTO> projects = projectService.findByLeader(username);
		
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<ProjectDTO> getProject(@PathVariable Long id){
		ProjectDTO retVal = projectService.findById(id);
		if (retVal == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ProjectDTO> addNew(@RequestBody ProjectDTO project){
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = ((User) currentUser.getPrincipal()).getEmail();
		ProjectDTO created = projectService.create(project, username);
		if(created == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(created, HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ProjectDTO> editProject(@RequestBody ProjectDTO project){
		ProjectDTO updated = projectService.update(project);
		if(updated == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/remove-developer", method = RequestMethod.PUT)
	public ResponseEntity<UserDTO> removeDeveloper(@RequestBody UserDTO user){
		boolean removed = projectService.removeDeveloper(user.getId());
		if(!removed) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteProject(@PathVariable Long id){
		try {
			projectService.delete(id);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
