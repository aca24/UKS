package com.github.minigithub.repository;

import com.github.minigithub.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    
    Task findOneById(Long id);
}
