package com.fronchak.workshopmongodb.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fronchak.workshopmongodb.domain.entities.User;
import com.fronchak.workshopmongodb.domain.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
}
