package com.github.minigithub.repository;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.minigithub.model.Milestone;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
	
	Milestone findOneById(Long id);
	
	Collection<Milestone> findByState(String state);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "DELETE FROM PROJECTS_MILESTONES WHERE MILESTONES_ID = ?1", nativeQuery = true)
	void deleteReferences(Long milestoneId);
}
