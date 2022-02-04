package com.github.minigithub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.github.minigithub.dto.UserDTO;
import com.github.minigithub.model.Role;
import com.github.minigithub.model.User;
import com.github.minigithub.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepositry;
    
    @Autowired
	private PasswordEncoder passwordEncoder;

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
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setActive(true);
        Role role = roleService.findById(1l).get();
        user.setRole(role);

        try {
        	user = userRepositry.save(user);

            userDTO.setId(user.getId());

            return userDTO;
        }
        catch(Exception e) {
        	return null;
        }
    }

    public UserDTO insertAdmin(UserDTO userDTO) {
        User user = new User(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        Role role = roleService.findById(2l).get();
        user.setRole(role);
        try {
        	userRepositry.save(user);
        	userDTO.setId(user.getId());

            return userDTO;
        }
        catch (Exception e) {
        	return null;
        }
        

        
    }

	public UserDTO editUser(UserDTO userDTO) {
		
		User existing = userRepositry.findById(userDTO.getId()).orElse(null);
		if(existing == null)
			return null;
		existing.setFirstName(userDTO.getFirstName());
		existing.setLastName(userDTO.getLastName());
		existing.setUsername(userDTO.getUsername());
		existing.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		try {
			userRepositry.save(existing);

            return userDTO;
        }
        catch (Exception e) {
        	return null;
        }
		
		
	}

	public UserDTO deactivate(UserDTO userDTO) {
		User existing = userRepositry.findById(userDTO.getId()).orElse(null);
		if(existing == null)
			return null;
		existing.setActive(false);
		try {
			userRepositry.save(existing);

            return userDTO;
        }
        catch (Exception e) {
        	return null;
        }
		
	}

	public List<UserDTO> searchByUsername(String username) {
		List<User> found = userRepositry.searchByUsername(username.toUpperCase());
		
		return toDtoList(found);
	}
	
	public List<UserDTO> toDtoList(List<User> users){
		List<UserDTO> retVal = new ArrayList<UserDTO>();
		for (User u: users) {
			retVal.add(new UserDTO(u));
		}
		return retVal;
	}
}
