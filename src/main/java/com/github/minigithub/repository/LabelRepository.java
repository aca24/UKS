package com.github.minigithub.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.minigithub.model.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long>{

	Label findOneById(Long id);
	
	<Optional> Label findByName(String name);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "DELETE FROM PROJECTS_LABELS WHERE LABELS_ID = ?1", nativeQuery = true)
	void deleteReferences(Long labelId);
}
