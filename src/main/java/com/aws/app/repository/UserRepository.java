package com.aws.app.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.aws.app.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	 Optional<User> findByEmail(String email);
	 List<User> findAllByActive(boolean state);
	 boolean existsByEmail(String email);
}
