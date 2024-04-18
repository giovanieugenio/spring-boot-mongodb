package com.spring.posts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.posts.domain.Post;
import com.spring.posts.repositories.PostRepository;
import com.spring.posts.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Optional<Post> findById(String id) {
		Optional<Post> user = postRepository.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Object not found.");
		}
		return user;
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
}