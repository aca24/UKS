package com.github.minigithub.repository;

import java.util.List;
import java.util.Optional;

import com.github.minigithub.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query(value ="SELECT * FROM USERS WHERE upper(username) LIKE %?1%", nativeQuery = true)
	List<User> searchByUsername(String username);
}
