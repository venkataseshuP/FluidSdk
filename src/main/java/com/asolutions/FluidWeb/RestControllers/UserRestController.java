package com.asolutions.FluidWeb.RestControllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asolutions.FluidWeb.Entities.User;
import com.asolutions.FluidWeb.Repositories.UserRepository;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {

		@Autowired
		private UserRepository userRepository;

		@PostMapping(value = "/user",
				consumes= {MediaType.APPLICATION_JSON_VALUE},
				produces= {MediaType.APPLICATION_JSON_VALUE})
		public User createUser(@RequestBody User user) {
			return userRepository.save(user);	
		}
		
		@GetMapping(value = "/users",
				produces= {MediaType.APPLICATION_JSON_VALUE})
		public Iterable<User> getusers(){
			return  userRepository.findAll();	
		} 
		
		@GetMapping(value="/user/{uid}")
		public Optional<User> getFileById(@PathVariable String uid) {
			return userRepository.findById(uid);
			
		}
}
