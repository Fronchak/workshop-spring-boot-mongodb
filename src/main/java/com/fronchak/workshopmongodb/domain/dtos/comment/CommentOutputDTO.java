package com.fronchak.workshopmongodb.domain.dtos.comment;

import java.io.Serializable;
import java.util.Date;

import com.fronchak.workshopmongodb.domain.dtos.user.AuthorDTO;

public class CommentOutputDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String text;
	private Date date;
	private AuthorDTO author;
	
	public CommentOutputDTO() {}

	public CommentOutputDTO(String text, Date date, AuthorDTO author) {
		this.text = text;
		this.date = date;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
}
