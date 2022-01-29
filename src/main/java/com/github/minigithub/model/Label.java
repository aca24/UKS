package com.github.minigithub.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}