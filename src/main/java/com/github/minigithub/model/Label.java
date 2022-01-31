package com.github.minigithub.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.github.minigithub.dto.LabelDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;

@Entity
@Table(name = "labels")
public class Label implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", unique = false, nullable = false)
	private String name;

	@ManyToOne()
	public LabelApplication labelApplication;

	public Label() {
	}

	public Label(Long id, String name, LabelApplication labelApplication) {
		this.id = id;
		this.name = name;
		this.labelApplication = labelApplication;
	}

	public Label(LabelDTO label) {
		this.id = label.getId();
		this.name = label.getName();
		this.labelApplication = new LabelApplication(label.getLabelApplication());
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

	public LabelApplication getLabelApplication() {
		return labelApplication;
	}

	public void setLabelApplication(LabelApplication labelApplication) {
		this.labelApplication = labelApplication;
	}
}