package com.fronchak.workshopmongodb.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fronchak.workshopmongodb.domain.mappers.PostMapper;
import com.fronchak.workshopmongodb.domain.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	@Autowired
	private PostMapper mapper;
}
