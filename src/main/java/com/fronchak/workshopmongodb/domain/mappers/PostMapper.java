package com.fronchak.workshopmongodb.domain.mappers;

import org.springframework.stereotype.Service;

import com.fronchak.workshopmongodb.domain.dtos.post.PostDTO;
import com.fronchak.workshopmongodb.domain.dtos.user.AuthorDTO;
import com.fronchak.workshopmongodb.domain.entities.Post;

@Service
public class PostMapper {

	public PostDTO convertEntityToDTO(Post entity) {
		PostDTO dto = new PostDTO();
		dto.setId(entity.getId());
		dto.setDate(entity.getDate());
		dto.setTitle(entity.getTitle());
		dto.setBody(entity.getBody());
		dto.setAuthor(convertEntityToPostAuthorDTO(entity.getAuthor()));
		return dto;
	}
	
	private PostDTO.PostAuthorDTO convertEntityToPostAuthorDTO(AuthorDTO entity) {
		PostDTO.PostAuthorDTO dto = new PostDTO.PostAuthorDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}
}
