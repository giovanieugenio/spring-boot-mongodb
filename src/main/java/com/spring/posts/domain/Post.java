package com.spring.posts.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.spring.posts.dto.AuthorDTO;
import com.spring.posts.dto.CommentDTO;

@Document
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private AuthorDTO authorDto;
	private Date date;
	private String title;
	private String body;
	private List<CommentDTO> comments = new ArrayList<>(); 
	
	public Post(){
	}

	public Post(AuthorDTO authorDto, String id, Date date, String title, String body) {
		super();
		this.authorDto = authorDto;
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
	}

	public AuthorDTO getAuthorDto() {
		return authorDto;
	}
	
	public void setAuthorDto(AuthorDTO authorDto) {
		this.authorDto = authorDto;
	}
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
	
	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
}