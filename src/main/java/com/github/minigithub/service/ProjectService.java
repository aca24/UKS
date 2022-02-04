package com.github.minigithub.service;

import java.util.Collection;
import java.util.List;
import com.github.minigithub.dto.ProjectDTO;
import com.github.minigithub.model.Project;


public interface ProjectService {

	Collection<ProjectDTO> findAll();
	
	ProjectDTO findById(Long id) ;


	ProjectDTO create(ProjectDTO project, String username);

	ProjectDTO update(ProjectDTO project);
	
	void delete(Long id);

	Collection<ProjectDTO> findByLeader(String username);

	boolean removeDeveloper(Long id);
}
