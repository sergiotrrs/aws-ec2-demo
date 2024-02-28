package com.aws.app.service;

import java.util.List;

import com.aws.app.model.User;

public interface UserService {
	
	User createUser(User user);
	List<User> getAllUsers(boolean isActive);
	User getUserById(Long userId);
	User getUserByEmail(String email);
	User updateUser(Long userId, User updatedUser);
	String deleteUser(Long userId);
	
}
