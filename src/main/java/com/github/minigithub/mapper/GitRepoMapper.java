package com.github.minigithub.mapper;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.minigithub.dto.BranchDTO;
import com.github.minigithub.dto.GitRepoDTO;
import com.github.minigithub.dto.ProjectDTO;
import com.github.minigithub.model.Branch;
import com.github.minigithub.model.GitRepo;
import com.github.minigithub.model.Project;

public class GitRepoMapper {
	
	@Autowired
	static
	BranchMapper branchMapper;
	
	
	

	public GitRepoMapper() {
		branchMapper = new BranchMapper();
	}

	public static GitRepo toEntity(GitRepoDTO dto) {
		ArrayList<Project> projects = new ArrayList<>();
		if(dto.getProjects() != null) {
			for (ProjectDTO projectDTO : dto.getProjects()) {
				projects.add(ProjectMapper.toEntity(projectDTO));
			}
		}
		
		ArrayList<Branch> branches = new ArrayList<>();
		if(dto.getBranches() != null) {
			for (BranchDTO branchDTO : dto.getBranches()) {
				branches.add(branchMapper.toEntity(branchDTO));
			}
		}
			
		GitRepo gr = new GitRepo();		
		gr.setId(dto.getId());
		gr.setName(dto.getName());
		gr.setBranches(branches);
		gr.setProjects(projects);
		
		return gr;
	}


	public static GitRepoDTO toDto(GitRepo entity) {
		ArrayList<ProjectDTO> projectsDTO = new ArrayList<>();
		for (Project project: entity.getProjects()) {
			projectsDTO.add(ProjectMapper.toDto(project));
		}
		
		ArrayList<BranchDTO> branchesDTO = new ArrayList<>();
		for (Branch branch: entity.getBranch()) {
			branchesDTO.add(branchMapper.toDto(branch));
		}
		
		GitRepoDTO grDTO = new GitRepoDTO(entity.getId(), entity.getName(), branchesDTO, projectsDTO);
		return grDTO;
	}

}
