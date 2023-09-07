package com.shelby.services;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.shelby.models.User;
import com.shelby.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public Iterator<User> getAllUsers() {
	 Iterable<User> data=userRepository.findAll();
	 Iterator<User> allUsers=data.iterator();
	 return allUsers;
	}
	public User getUserById(int id) {
		User userById= userRepository.findById(id).orElseThrow(
				()->{
					throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				});
		return userById;
	}

	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}
	
}
