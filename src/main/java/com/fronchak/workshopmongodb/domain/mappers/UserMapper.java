package com.fronchak.workshopmongodb.domain.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fronchak.workshopmongodb.domain.dtos.user.UserDTO;
import com.fronchak.workshopmongodb.domain.entities.User;

@Service
public class UserMapper {

	public List<UserDTO> convertEntityListToDTOList(List<User> list) {
		return list.stream()
			.map(entity -> convertEntityToDTO(entity))
			.collect(Collectors.toList());
	}
	
	public UserDTO convertEntityToDTO(User entity) {
		UserDTO dto = new UserDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		return dto;
	}
	
	public void copyDTOToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
	}
}
