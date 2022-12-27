package com.fronchak.workshopmongodb.domain.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fronchak.workshopmongodb.domain.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
