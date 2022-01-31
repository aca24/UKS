package com.github.minigithub.dto;

import java.util.Collection;

public class GitRepoDTO {
	
	private Long id;
	private String name;
	private Collection<BranchDTO> branches;
	private Collection<ProjectDTO> projects;
	
	
	
	public GitRepoDTO(Long id, String name, Collection<BranchDTO> branches, Collection<ProjectDTO> projects) {
		super();
		this.id = id;
		this.name = name;
		this.branches = branches;
		this.projects = projects;
	}
	public GitRepoDTO() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<BranchDTO> getBranches() {
		return branches;
	}
	public void setBranches(Collection<BranchDTO> branches) {
		this.branches = branches;
	}
	public Collection<ProjectDTO> getProjects() {
		return projects;
	}
	public void setProjects(Collection<ProjectDTO> projects) {
		this.projects = projects;
	}
	
	

}
