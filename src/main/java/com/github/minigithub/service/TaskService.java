package com.github.minigithub.service;

import java.util.List;

import com.github.minigithub.dto.TaskDTO;
import com.github.minigithub.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    Task findOne(Long id);

    List<Task> findAll();

    Page<Task> findAll(Pageable page);

    Task save(TaskDTO Task);

    Task update(TaskDTO Task) throws Exception;

    void remove(Long id);

}
