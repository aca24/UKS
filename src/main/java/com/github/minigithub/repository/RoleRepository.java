package com.github.minigithub.repository;

import java.util.Optional;

import com.github.minigithub.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Optional<Role> findByName(String name);
}
