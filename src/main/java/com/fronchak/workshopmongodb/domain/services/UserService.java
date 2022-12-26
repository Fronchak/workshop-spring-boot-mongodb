package com.fronchak.workshopmongodb.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fronchak.workshopmongodb.domain.dtos.user.UserDTO;
import com.fronchak.workshopmongodb.domain.entities.User;
import com.fronchak.workshopmongodb.domain.exceptions.ResourceNotFoundException;
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
	
	public UserDTO findById(String id) {
		User entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found by ID: " + id));
		return mapper.convertEntityToDTO(entity);
	}
	
	public UserDTO save(UserDTO insertDTO) {
		User entity = new User();
		mapper.copyDTOToEntity(insertDTO, entity);
		entity = repository.save(entity);
		return mapper.convertEntityToDTO(entity);
	}
	
	public void delete(String id) {
		repository.deleteById(id);
	}
	
	@Transactional
	public UserDTO update(UserDTO dto, String id) {
		User entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found by ID: " + id));
		mapper.copyDTOToEntity(dto, entity);
		entity = repository.save(entity);
		return mapper.convertEntityToDTO(entity);
	}
}
