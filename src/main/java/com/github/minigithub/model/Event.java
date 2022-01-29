package com.github.minigithub.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.github.minigithub.dto.EventDTO;
import com.github.minigithub.dto.TaskDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Entity
@Table(name = "events")
@Inheritance(strategy = TABLE_PER_CLASS)
public class Event implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ConfirmationCodeGeneratorOne")
	@TableGenerator(table = "SEQUENCES_EVENT", name = "ConfirmationCodeGeneratorOne")
	private Long id;

	@Column(name = "dateTime", unique = false, nullable = false)
	private Date dateTime;

	@ManyToOne()
	public Task task;

	public Event(Long id, Date dateTime, Task task) {
		this.id = id;
		this.dateTime = dateTime;
		this.task = task;
	}

	public Event(EventDTO event) {
		this.id = event.getId();
		this.dateTime = event.getDateTime();
		this.task = new Task(event.getTask());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
}