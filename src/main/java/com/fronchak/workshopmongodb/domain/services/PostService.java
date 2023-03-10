package com.fronchak.workshopmongodb.domain.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fronchak.workshopmongodb.domain.dtos.post.PostDTO;
import com.fronchak.workshopmongodb.domain.entities.Post;
import com.fronchak.workshopmongodb.domain.exceptions.ResourceNotFoundException;
import com.fronchak.workshopmongodb.domain.mappers.PostMapper;
import com.fronchak.workshopmongodb.domain.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	@Autowired
	private PostMapper mapper;
	
	@Transactional(readOnly = true)
	public PostDTO findById(String id) {
		Post entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Post not found by ID: " + id));
		return mapper.convertEntityToDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public List<PostDTO> findByTitle(String text) {
		List<Post> list = repository.findByTitleContainingIgnoreCase(text);
		return mapper.convertEntityListToOutputDTOList(list);
	}
	
	@Transactional(readOnly = true)
	public List<PostDTO> searchTitle(String text) {
		List<Post> list = repository.searchTitle(text);
		return mapper.convertEntityListToOutputDTOList(list);
	}
	
	@Transactional(readOnly = true)
	public List<PostDTO> fullSearch(String text, Date start, Date end) {
		end = new Date(end.getTime() + 24 * 60 * 60 * 1000);
		List<Post> list = repository.fullSearch(text, start, end);
		return mapper.convertEntityListToOutputDTOList(list);
	}
}
