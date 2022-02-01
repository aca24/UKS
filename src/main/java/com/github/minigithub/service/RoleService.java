package com.github.minigithub.service;

import java.util.List;
import java.util.Optional;

import com.github.minigithub.model.Role;
import com.github.minigithub.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    public RoleRepository roleRepositry;

    public List<Role> findAll() {
        return roleRepositry.findAll();
    }

    public Optional<Role> findById(Long id) {
        return roleRepositry.findById(id);
    }

    public Optional<Role> findByName(String name) {
        return roleRepositry.findByName(name);
    }
}
