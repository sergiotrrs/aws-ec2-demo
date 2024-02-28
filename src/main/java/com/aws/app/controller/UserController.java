package com.aws.app.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.aws.app.model.User;
import com.aws.app.service.UserService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/v1/users")
public class UserController {

	UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@Validated @RequestBody User newUser) {
	    User savedUser = userService.createUser(newUser);
	    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(
			@RequestParam(name="active", required=false, defaultValue="true") boolean isActive
			) {
		List<User> users = userService.getAllUsers(isActive);			   
	    return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
	    User existingUser = userService.getUserById(userId);
	    return new ResponseEntity<>(existingUser, HttpStatus.OK);
	}
	
	@GetMapping("query")
	public ResponseEntity<User> getUserByEmail(@RequestParam(name="email") String email) {
	    User existingUser = userService.getUserByEmail(email);
	    return new ResponseEntity<>(existingUser, HttpStatus.OK);
	}

	@PutMapping("{userId}")
	public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @Validated @RequestBody User updatedUser) {
	    User existingUser = userService.updateUser(userId, updatedUser);
	    return new ResponseEntity<>(existingUser, HttpStatus.OK);
	}

	@DeleteMapping("{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) {
		String message = userService.deleteUser(userId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	
}
