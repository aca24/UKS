package com.github.minigithub.repository;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.minigithub.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	Project findOneById(Long id);
	
	Collection<Project> findByTitle(String title);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "DELETE FROM developers_projects WHERE user_id = ?1", nativeQuery = true)
	void removeDeveloper(Long id);
}
