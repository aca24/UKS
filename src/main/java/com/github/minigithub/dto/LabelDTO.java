package com.github.minigithub.dto;

import java.util.Collection;

public class LabelDTO {

	private Long id;
	private String name;
	private LabelApplicationDTO labelApplication;
	
	
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
	public LabelDTO(Long id, String name, LabelApplicationDTO labelApplication) {
		super();
		this.id = id;
		this.name = name;
		this.labelApplication = labelApplication;
	}
	public LabelApplicationDTO getLabelApplication() {
		return labelApplication;
	}
	public void setLabelApplication(LabelApplicationDTO labelApplication) {
		this.labelApplication = labelApplication;
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
