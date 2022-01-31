package com.github.minigithub.mapper;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.minigithub.dto.BranchDTO;
import com.github.minigithub.dto.GitRepoDTO;
import com.github.minigithub.dto.IssueDTO;
import com.github.minigithub.dto.ProjectDTO;
import com.github.minigithub.dto.PullRequestDTO;
import com.github.minigithub.model.Branch;
import com.github.minigithub.model.GitRepo;
import com.github.minigithub.model.Issue;
import com.github.minigithub.model.Project;
import com.github.minigithub.model.PullRequest;
import com.github.minigithub.model.User;

public class GitRepoMapper implements MapperInterface<GitRepo, GitRepoDTO> {
	
	@Autowired
	BranchMapper branchMapper;
	
	
	

	public GitRepoMapper() {
		branchMapper = new BranchMapper();
	}

	@Override
	public GitRepo toEntity(GitRepoDTO dto) {
		ArrayList<Project> projects = new ArrayList<>();
		for (ProjectDTO projectDTO : dto.getProjects()) {
			projects.add(ProjectMapper.toEntity(projectDTO));
		}
		
		ArrayList<Branch> branches = new ArrayList<>();
		for (BranchDTO branchDTO : dto.getBranches()) {
			branches.add(branchMapper.toEntity(branchDTO));
		}
		
		GitRepo gr = new GitRepo(dto.getId(), dto.getName(), branches, projects);		
		return gr;
	}

	@Override
	public GitRepoDTO toDto(GitRepo entity) {
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
