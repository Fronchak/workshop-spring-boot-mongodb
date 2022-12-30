package com.fronchak.workshopmongodb.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fronchak.workshopmongodb.api.util.UrlDecoder;
import com.fronchak.workshopmongodb.domain.dtos.post.PostDTO;
import com.fronchak.workshopmongodb.domain.services.PostService;

@RestController
@RequestMapping(value = "/api/posts")
public class PostController {

	@Autowired
	private PostService service;
	
	@Autowired
	private UrlDecoder decoder;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id) {
		PostDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(name = "title", defaultValue = "") String title) {
		String text = decoder.decodeParam(title);
		List<PostDTO> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
