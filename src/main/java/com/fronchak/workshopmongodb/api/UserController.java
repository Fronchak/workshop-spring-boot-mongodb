package com.fronchak.workshopmongodb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fronchak.workshopmongodb.domain.entities.User;
import com.fronchak.workshopmongodb.domain.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
