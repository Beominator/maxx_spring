package com.movieAndgame.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class GamePostDto {

	private int post_id;
	private String writer;
	
	@NotBlank(message="제목은 꼭 입력하세요")
	private String title;
	
	@NotBlank(message="게임이름은 꼭 입력하세요")
	private String game_name;
	
	@Size(min=10, max=300, message="최소 10자 이상 작성하세요")
	private String target_post;
	private LocalDateTime write_date;
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
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
	public String getGame_name() {
		return game_name;
	}
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}
	public String getTarget_post() {
		return target_post;
	}
	public void setTarget_post(String target_post) {
		this.target_post = target_post;
	}
	public LocalDateTime getWrite_date() {
		return write_date;
	}
	public void setWrite_date(LocalDateTime write_date) {
		this.write_date = write_date;
	}
}
	