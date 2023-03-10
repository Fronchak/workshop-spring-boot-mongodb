package com.fronchak.workshopmongodb.domain.dtos.user;

import java.io.Serializable;

import com.fronchak.workshopmongodb.domain.entities.User;

public class AuthorDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDTO() {}
	
	public AuthorDTO(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public AuthorDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
