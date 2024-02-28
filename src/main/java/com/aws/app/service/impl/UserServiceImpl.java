package com.aws.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aws.app.model.User;
import com.aws.app.repository.UserRepository;
import com.aws.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User user) {
		checkUserNotExistByEmail(user.getEmail());
		user.setActive(true);
		return saveUser(user);
	}
	
	private void checkUserNotExistByEmail(String email) {
		if ( userRepository.existsByEmail(email) ) {
			throw new IllegalStateException("Email " + email + " already exists. Please choose a different email address");
		}		
	}
	
	private User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers(boolean isActive) {
		List<User> users;
		if(isActive) {
			users = getAllActiveUsers();
		} else {
			users = getAllInactiveUsers();
		}	    
	    return users;
	}
	
	private List<User> getAllActiveUsers() {
		return userRepository.findAllByActive(true);
	}	

	private List<User> getAllInactiveUsers() {
		return userRepository.findAllByActive(false);
	}

	@Override
	public User getUserById(Long userId) {		
		return userRepository.findById(userId)
				.orElseThrow( ()-> new IllegalStateException("User does not exist with id " + userId));
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email)
				.orElseThrow( ()-> new IllegalStateException("User does not exist with email " + email));
	}
	
	@Override
	public User updateUser(Long userId, User updatedUser) {
		User existingUser = getUserById(userId);
		existingUser.setFirstName( updatedUser.getFirstName());
		existingUser.setLastName( updatedUser.getLastName());
		existingUser.setPassword( updatedUser.getPassword());
		
		return saveUser(existingUser);
	}

	@Override
	public String deleteUser(Long userId) {
		User existingUser = getUserById(userId);
		existingUser.setActive(false);
		saveUser(existingUser);
		return "User succesfully deleted with id " + userId;
	}

}
