package com.github.minigithub.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.minigithub.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	Project findOneById(Long id);
	
	Collection<Project> findByTitle(String title);
}
