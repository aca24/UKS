package com.github.minigithub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.minigithub.model.GitRepo;
import com.github.minigithub.model.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long>{

	
	 @Query(value ="SELECT * FROM HISTORY WHERE comment LIKE %?1%", nativeQuery = true)
	List<History> searchByComment(String input);

}
