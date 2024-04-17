package com.spring.posts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.posts.domain.User;
import com.spring.posts.dto.UserDTO;
import com.spring.posts.repositories.UserRepository;
import com.spring.posts.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public Optional<User> findById(String id) {
		Optional<User> user = userRepository.findById(id);
		if(user == null) {
			throw new ObjectNotFoundException("Object not found.");
		}
		return user;
	}
	
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
}