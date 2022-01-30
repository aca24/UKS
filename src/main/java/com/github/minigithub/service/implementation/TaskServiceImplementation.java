package com.github.minigithub.service.implementation;

import org.springframework.stereotype.Service;

import java.util.List;

import com.github.minigithub.dto.TaskDTO;
import com.github.minigithub.model.Task;
import com.github.minigithub.repository.TaskRepository;
import com.github.minigithub.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImplementation implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImplementation(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
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
    public Task save(TaskDTO Task) {
        Task task = new Task();

        try {
            task.setEvent(task.getEvent());
            task.setMilestone(task.getMilestone());
            task.setCreator(task.getCreator());
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
            task.setEvent(task.getEvent());
            task.setMilestone(task.getMilestone());
            task.setCreator(task.getCreator());
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