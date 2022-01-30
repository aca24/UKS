package com.github.minigithub.service.implementation;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.minigithub.dto.EventDTO;
import com.github.minigithub.dto.TaskDTO;
import com.github.minigithub.model.Task;
import com.github.minigithub.model.User;
import com.github.minigithub.model.Event;
import com.github.minigithub.model.Milestone;
import com.github.minigithub.repository.EventRepository;
import com.github.minigithub.repository.TaskRepository;
import com.github.minigithub.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImplementation implements TaskService {

    private TaskRepository taskRepository;
    private EventRepository eventRepository;

    @Autowired
    public TaskServiceImplementation(TaskRepository taskRepository, EventRepository eventRepository) {
        this.taskRepository = taskRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public Task findOne(Long id) {
        return taskRepository.findById(id).orElseGet(null);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Page<Task> findAll(Pageable page) {
        return taskRepository.findAll(page);
    }

    @Override
    public Task save(TaskDTO taskDTO) {
        Task task = new Task();

        try {
            Collection<Event> events = new ArrayList<Event>();
		    for(EventDTO dto: taskDTO.getEvents()) {
			    events.add(eventRepository.findById(dto.getId()).orElse(null));
	    	}
		    task.setEvent(events);
            task.setMilestone(new Milestone(taskDTO.getMilestone()));
            task.setCreator(new User(taskDTO.getCreator()));
            taskRepository.save(task);
        } catch (Exception e) {
            return null;
        }

        return task;
    }

    @Override
    public Task update(TaskDTO taskDTO) throws Exception {
        Task task = new Task();
        task = taskRepository.getById(taskDTO.getId());

        try {
            Collection<Event> events = new ArrayList<Event>();
		    for(EventDTO dto: taskDTO.getEvents()) {
			    events.add(eventRepository.findById(dto.getId()).orElse(null));
	    	}
		    task.setEvent(events);
            task.setMilestone(new Milestone(taskDTO.getMilestone()));
            task.setCreator(new User(taskDTO.getCreator()));
            taskRepository.save(task);
        } catch (Exception e) {
            return null;
        }

        return task;
    }

    @Override
    public void remove(Long id) {
        taskRepository.deleteById(id);
    }
}