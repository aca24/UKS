package com.github.minigithub.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import javax.persistence.InheritanceType;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Entity
@Table(name="events")
@Inheritance(strategy=TABLE_PER_CLASS)
public class Event implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Column(name = "dateTime", unique = false, nullable = false)
	private Date dateTime;

	@ManyToOne()
	public Task task;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}