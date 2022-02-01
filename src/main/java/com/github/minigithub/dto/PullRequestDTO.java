package com.github.minigithub.dto;

import java.util.List;

public class PullRequestDTO extends TaskDTO {
	
	private Long id;
	private String name;
	private BranchDTO branch;
	private List<IssueDTO> issues;
	
	public PullRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PullRequestDTO(Long id, String name, BranchDTO branch, List<IssueDTO> issues) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.issues = issues;
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
	public BranchDTO getBranch() {
		return branch;
	}
	public void setBranch(BranchDTO branch) {
		this.branch = branch;
	}
	public List<IssueDTO> getIssues() {
		return issues;
	}
	public void setIssues(List<IssueDTO> issues) {
		this.issues = issues;
	}
	
	
	

}
