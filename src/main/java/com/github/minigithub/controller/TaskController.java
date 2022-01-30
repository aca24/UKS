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
import org.springframework.web.bind.annotation.RequestMapping;
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

}
