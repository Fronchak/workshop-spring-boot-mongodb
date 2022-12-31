package com.fronchak.workshopmongodb.domain.dtos.post;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fronchak.workshopmongodb.domain.dtos.comment.CommentOutputDTO;

public class PostDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private Date date;
	private String title;
	private String body;
	private PostAuthorDTO author;
	
	private List<CommentOutputDTO> comments = new ArrayList<>();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public PostAuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(PostAuthorDTO author) {
		this.author = author;
	}
	
	public List<CommentOutputDTO> getComments() {
		return comments;
	}
	
	public void addComment(CommentOutputDTO comment) {
		comments.add(comment);
	}
	
	public static class PostAuthorDTO implements Serializable {
	
		private static final long serialVersionUID = 1L;
		
		private String id;
		private String name;
		
		public PostAuthorDTO() {}
		
		public PostAuthorDTO(String id, String name) {
			this.id = id;
			this.name = name;
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
}
