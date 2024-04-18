package com.spring.posts.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.posts.domain.Post;
import com.spring.posts.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
	    Optional<Post> obj = postService.findById(id);
		if(obj != null) {
			return ResponseEntity.ok().body(obj.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}