package com.spring.posts.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.posts.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
