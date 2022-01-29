package com.github.minigithub.repository;

import com.github.minigithub.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
    
    Task findOneById(Long id);
}
