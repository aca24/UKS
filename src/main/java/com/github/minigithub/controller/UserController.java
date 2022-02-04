package com.github.minigithub.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.minigithub.dto.ProjectDTO;
import com.github.minigithub.dto.UserDTO;
import com.github.minigithub.model.Role;
import com.github.minigithub.model.User;
import com.github.minigithub.security.TokenUtils;
import com.github.minigithub.service.RoleService;
import com.github.minigithub.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

     @Autowired
     public UserService userService;
     
     @Autowired
     private TokenUtils tokenUtils;
     
     @Autowired
     private RoleService roleService;

     @RequestMapping(method = RequestMethod.GET)
     public ResponseEntity<List<UserDTO>> findAll() {
    	 return new ResponseEntity<>(
    			userService.findAll().stream().map((user) -> new
    			UserDTO(user)).collect(Collectors.toList()),
    			HttpStatus.OK);
     }

     @RequestMapping(method = RequestMethod.GET, value = "/{id}")
     public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
    	 Optional<User> user = userService.findById(id);

    	 if (user.isEmpty()) {
    		 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    	 }
    	 return new ResponseEntity<>(new UserDTO(user.get()), HttpStatus.OK);
     }
     
     @RequestMapping(method = RequestMethod.GET, value = "/current")
     public ResponseEntity<UserDTO> getCurrentUser() {
    	 
    	 Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
         String username = ((User) currentUser.getPrincipal()).getEmail();
         User current = userService.findByUsername(username).orElse(null);
    	 if (current == null)
    		 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    	 
    	 return new ResponseEntity<>(new UserDTO(current), HttpStatus.OK);
     }

     @RequestMapping(method = RequestMethod.GET, value = "/{username}")
     public ResponseEntity<UserDTO> findByUsername(@PathVariable String username) {
     Optional<User> user = userService.findByUsername(username);

     	if (user.isEmpty()) {
     		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
     	}
     	return new ResponseEntity<>(new UserDTO(user.get()), HttpStatus.OK);
     }

//     @RequestMapping(method = RequestMethod.POST)
//     public ResponseEntity<UserDTO> insertUser(@RequestBody UserDTO userDTO) {
//    	 UserDTO saved = userService.insertUser(userDTO);
//    	 if(saved != null) {
//    		 return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//    	 }
//
//      return new ResponseEntity<>(saved, HttpStatus.OK);
//     }
     
     @RequestMapping(value="/{id}", method = RequestMethod.PUT)
     public ResponseEntity<UserDTO> editUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {
    	 UserDTO saved = userService.editUser(userDTO);
    	 if(saved == null) {
    		 return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    	 }

      return new ResponseEntity<>(saved, HttpStatus.OK);
     }

     @RequestMapping(value= "/deactivate",method = RequestMethod.PUT)
     public ResponseEntity<UserDTO> deactivateAccount(@RequestBody UserDTO userDTO) {
    	 UserDTO saved = userService.deactivate(userDTO);
    	 if(saved == null) {
    		 return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    	 }

      return new ResponseEntity<>(saved, HttpStatus.OK);
     }

     @RequestMapping(value = "/search/{input}", method = RequestMethod.GET)
 	public ResponseEntity<List<UserDTO>> searchByUsername(@PathVariable String input){
 		
         List<UserDTO> retVal = userService.searchByUsername(input);
 		
 		return new ResponseEntity<>(retVal, HttpStatus.OK);
 	}
   
}
