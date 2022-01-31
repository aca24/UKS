package com.github.minigithub.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.minigithub.dto.UserDTO;
import com.github.minigithub.model.Role;
import com.github.minigithub.model.User;
import com.github.minigithub.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    // @Autowired
    // public UserService userService;

    // public ResponseEntity<List<UserDTO>> findAll() {
    // return new ResponseEntity<>(
    // userService.findAll().stream().map((user) -> new
    // UserDTO(user)).collect(Collectors.toList()),
    // HttpStatus.OK);
    // }

    // public ResponseEntity<UserDTO> findById(Long id) {
    // Optional<User> user = userService.findById(id);

    // if (user.isEmpty()) {
    // return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    // }
    // return new ResponseEntity<>(new UserDTO(user.get()), HttpStatus.OK);
    // }

    // public ResponseEntity<UserDTO> findByUsername(String username) {
    // Optional<User> user = userService.findByUsername(username);

    // if (user.isEmpty()) {
    // return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    // }
    // return new ResponseEntity<>(new UserDTO(user.get()), HttpStatus.OK);
    // }

    // public ResponseEntity<UserDTO> insertUser(UserDTO userDTO) {
    // User user = new User(userDTO);

    // Role role = roleService.findById(1l).get();
    // user.setRole(role);

    // userRepositry.save(user);

    // userDTO.setId(user.getId());

    // return userDTO;
    // }

    // public ResponseEntity<UserDTO> insertAdmin(UserDTO userDTO) {
    // User user = new User(userDTO);

    // Role role = roleService.findById(2l).get();
    // user.setRole(role);

    // userRepositry.save(user);

    // userDTO.setId(user.getId());

    // return userDTO;
    // }
}
