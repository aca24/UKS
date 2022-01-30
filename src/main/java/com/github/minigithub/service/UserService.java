package com.github.minigithub.service;

import java.util.List;
import java.util.Optional;

import com.github.minigithub.dto.UserDTO;
import com.github.minigithub.model.Role;
import com.github.minigithub.model.User;
import com.github.minigithub.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepositry;

    @Autowired
    public RoleService roleService;

    public List<User> findAll() {
        return userRepositry.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepositry.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepositry.findByUsername(username);
    }

    public UserDTO insertUser(UserDTO userDTO) {
        User user = new User(userDTO);

        Role role = roleService.findById(1l).get();
        user.setRole(role);

        userRepositry.save(user);

        userDTO.setId(user.getId());

        return userDTO;
    }

    public UserDTO insertAdmin(UserDTO userDTO) {
        User user = new User(userDTO);

        Role role = roleService.findById(2l).get();
        user.setRole(role);

        userRepositry.save(user);

        userDTO.setId(user.getId());

        return userDTO;
    }
}
