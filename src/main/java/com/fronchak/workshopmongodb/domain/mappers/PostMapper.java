package com.fronchak.workshopmongodb.domain.mappers;

import org.springframework.stereotype.Service;

import com.fronchak.workshopmongodb.domain.dtos.post.PostDTO;
import com.fronchak.workshopmongodb.domain.entities.Post;
import com.fronchak.workshopmongodb.domain.entities.User;

@Service
public class PostMapper {

	public PostDTO convertEntityToDTO(Post entity) {
		PostDTO dto = new PostDTO();
		dto.setId(entity.getId());
		dto.setDate(entity.getDate());
		dto.setTitle(entity.getTitle());
		dto.setBody(entity.getBody());
	
		return dto;
	}
	
	private PostDTO.PostAuthorDTO convertEntityToPostAuthorDTO(User entity) {
		PostDTO.PostAuthorDTO dto = new PostDTO.PostAuthorDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}
}
