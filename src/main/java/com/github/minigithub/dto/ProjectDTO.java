package com.github.minigithub.dto;

import java.util.Collection;

public class ProjectDTO {

	private Long id;
	private String title;
	private GitRepoDTO gitRepo;
	private Collection<MilestoneDTO> milestones;
	private Collection<LabelDTO> labesls;
	private Collection<UserDTO> developers;
	private UserDTO leader;
	
	public Collection<UserDTO> getDevelopers() {
		return developers;
	}

	public void setDevelopers(Collection<UserDTO> developers) {
		this.developers = developers;
	}

	public GitRepoDTO getGitRepo() {
		return gitRepo;
	}

	public void setGitRepo(GitRepoDTO gitRepo) {
		this.gitRepo = gitRepo;
	}
	public UserDTO getLeader() {
		return leader;
	}

	public void setLeader(UserDTO leader) {
		this.leader = leader;
	}

	
	public ProjectDTO() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Collection<MilestoneDTO> getMilestones() {
		return milestones;
	}
	public void setMilestones(Collection<MilestoneDTO> milestones) {
		this.milestones = milestones;
	}
	public Collection<LabelDTO> getLabesls() {
		return labesls;
	}
	public void setLabesls(Collection<LabelDTO> labesls) {
		this.labesls = labesls;
	}
	
	
	
}
