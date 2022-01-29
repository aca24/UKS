package com.github.minigithub.mapper;

import com.github.minigithub.dto.ProjectDTO;
import com.github.minigithub.model.Project;

public class ProjectMapper {

	
	public static ProjectDTO toDto (Project entity) {
		return new ProjectDTO();
		// TO DO 
		// setuj DTO objekat
	}
	
	public static Project toEntity (ProjectDTO dto) {
		return new Project();
		// TO DO
	}
}
