package com.github.minigithub.service;

import java.util.Collection;
import java.util.List;
import com.github.minigithub.dto.ProjectDTO;
import com.github.minigithub.model.Project;


public interface ProjectService {

	Collection<ProjectDTO> findAll();
	
	ProjectDTO findById(Long id) ;

	//TO DO 
	ProjectDTO create(ProjectDTO project);

	ProjectDTO update(ProjectDTO project);
	
	void delete(Long id);

	Collection<ProjectDTO> findByLeader(String username);
}
