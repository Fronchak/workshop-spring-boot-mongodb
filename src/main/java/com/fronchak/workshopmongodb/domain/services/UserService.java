package com.fronchak.workshopmongodb.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fronchak.workshopmongodb.domain.dtos.user.UserDTO;
import com.fronchak.workshopmongodb.domain.entities.User;
import com.fronchak.workshopmongodb.domain.mappers.UserMapper;
import com.fronchak.workshopmongodb.domain.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserMapper mapper;

	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		return mapper.convertEntityListToDTOList(list);
	}
}
