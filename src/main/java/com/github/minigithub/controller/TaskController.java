package com.github.minigithub.controller;

import java.util.ArrayList;
import java.util.List;

import com.github.minigithub.dto.TaskDTO;
import com.github.minigithub.mapper.TaskMapper;
import com.github.minigithub.model.Task;
import com.github.minigithub.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/task", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {
    
	private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<TaskDTO>> getTasks() {
        List<Task> tasks = taskService.findAll();

        List<TaskDTO> tasksDTO = new ArrayList<TaskDTO>();
        for (Task task : tasks) {
            tasksDTO.add(TaskMapper.toDto(task));
        }

        return new ResponseEntity<>(tasksDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable Long id) {
        Task task;
        try {
            task = taskService.findOne(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(TaskMapper.toDto(task), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<TaskDTO> saveTask(@RequestBody TaskDTO taskDTO) {
        Task task = new Task();
        try {
            task = taskService.save(taskDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(TaskMapper.toDto(task), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id,
            @RequestBody TaskDTO taskDTO) {
        Task task;
        try {
            task = taskService.findOne(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            task = taskService.update(taskDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(TaskMapper.toDto(task), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        Task task;
        try {
            task = taskService.findOne(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        taskService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
