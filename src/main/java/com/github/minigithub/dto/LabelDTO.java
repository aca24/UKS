package com.github.minigithub.dto;

public class LabelDTO {

	private Long id;
	private String name;
//	private Set<LabelApplicationDTO> labelApplication;
	
	
	public Long getId() {
		return id;
	}
	public LabelDTO() {
		super();
	}
	public LabelDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
