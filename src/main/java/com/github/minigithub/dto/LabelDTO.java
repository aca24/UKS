package com.github.minigithub.dto;

import java.util.Collection;

import com.github.minigithub.model.Label;
import com.github.minigithub.model.LabelApplication;

public class LabelDTO {

	private Long id;
	private String name;
	private LabelApplicationDTO labelApplication;

	public LabelDTO() {
	}

	public LabelDTO(Long id, String name, LabelApplicationDTO labelApplication) {
		this.id = id;
		this.name = name;
		this.labelApplication = labelApplication;
	}

	public LabelDTO(Label label) {
		this.id = label.getId();
		this.name = label.getName();
		this.labelApplication = new LabelApplicationDTO(label.getLabelApplication());
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

	public LabelApplicationDTO getLabelApplication() {
		return labelApplication;
	}

	public void setLabelApplication(LabelApplicationDTO labelApplication) {
		this.labelApplication = labelApplication;
	}
}
