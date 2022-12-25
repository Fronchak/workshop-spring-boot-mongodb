package com.fronchak.workshopmongodb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fronchak.workshopmongodb.domain.User;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = new ArrayList<>();
		list.add(new User("1", "Gabriel", "gabriel@gmail.com"));
		list.add(new User("2", "Alice", "alice@gmail.com"));
		return ResponseEntity.ok().body(list);
	}
}
