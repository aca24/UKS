package com.github.minigithub.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.minigithub.dto.UserDTO;
import com.github.minigithub.model.User;
import com.github.minigithub.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return new ResponseEntity<>(
                userService.findAll().stream().map((user) -> new UserDTO(user)).collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(Long id) {
        Optional<User> user = userService.findById(id);

        if (user.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new UserDTO(user.get()), HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDTO> findByUsername(String username) {
        Optional<User> user = userService.findByUsername(username);

        if (user.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new UserDTO(user.get()), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<UserDTO> insertUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.insertUser(userDTO), HttpStatus.CREATED);
    }

    @PostMapping("/admin")
    public ResponseEntity<UserDTO> insertAdmin(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.insertAdmin(userDTO), HttpStatus.CREATED);
    }
}
