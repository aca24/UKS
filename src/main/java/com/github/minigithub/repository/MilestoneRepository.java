package com.github.minigithub.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.minigithub.model.Milestone;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
	
	Milestone findOneById(Long id);
	
	Collection<Milestone> findByState(String state);

}
