package com.spring.posts.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.spring.posts.domain.Post;
import com.spring.posts.domain.User;
import com.spring.posts.dto.AuthorDTO;
import com.spring.posts.dto.CommentDTO;
import com.spring.posts.repositories.PostRepository;
import com.spring.posts.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(new AuthorDTO(alex), null, simpleDateFormat.parse("18/04/2024"), "#GoTravel", "I'm going to travel to Frankfurt later today :)");
		Post post2 = new Post(new AuthorDTO(alex), null, simpleDateFormat.parse("18/04/2024"), "#GoTravel", "I've arrived, and it's getting really cold");

		CommentDTO c1 = new CommentDTO("Very cool! I'll also be in Germany next week", simpleDateFormat.parse("19/04/2024"), new AuthorDTO(maria));
		CommentDTO c2 = new CommentDTO("The city is really very beautiful", simpleDateFormat.parse("20/04/2024"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Bring me some gift cousin", simpleDateFormat.parse("20/04/2024"), new AuthorDTO(bob));

		post1.getComments().addAll(Arrays.asList(c1));
		post2.getComments().addAll(Arrays.asList(c2, c3));

		
		postRepository.saveAll(Arrays.asList(post1, post2));
	
		alex.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(alex);
	}
}