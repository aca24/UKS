package com.github.minigithub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.minigithub.model.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long>{

	Label findOneById(Long id);
	
	<Optional> Label findByName(String name);
}
