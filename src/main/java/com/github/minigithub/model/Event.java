package com.github.minigithub.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.github.minigithub.dto.EventDTO;
import javax.persistence.*;

@Entity
@Table(name = "events")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Event implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ConfirmationCodeGeneratorOne")
	@TableGenerator(table = "SEQUENCES_EVENT", name = "ConfirmationCodeGeneratorOne")
	private Long id;

	@Column(name = "creationTime", unique = false, nullable = false)
	private LocalDateTime creationTime;

	@ManyToOne
	public Task task;

	public Event() {
	}

	public Event(Long id, LocalDateTime creationTime, Task task) {
		this.id = id;
		this.creationTime = creationTime;
		this.task = task;
	}

	public Event(EventDTO event) {
		this.id = event.getId();
		this.creationTime = event.getCreationTime();
		this.task = new Task(event.getTask());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
}