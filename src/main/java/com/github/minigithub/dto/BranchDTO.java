package com.github.minigithub.dto;


//nije dovrsena klasa
public class BranchDTO {
	   private Long id;
	   private String name;
	public BranchDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BranchDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	   


}
