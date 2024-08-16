package com.movieAndgame.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class GamePostDto {

	private int postId;
	private String writer;
	
	@NotBlank(message="제목은 꼭 입력하세요")
	private String title;
	
	@NotBlank(message="게임이름은 꼭 입력하세요")
	private String gameName;
	
	@Size(min=10, max=300, message="최소 10자 이상 작성하세요")
	private String targetPost;
	private LocalDateTime writeDate;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getTargetPost() {
		return targetPost;
	}
	public void setTargetPost(String targetPost) {
		this.targetPost = targetPost;
	}
	public LocalDateTime getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(LocalDateTime writeDate) {
		this.writeDate = writeDate;
	}
}
