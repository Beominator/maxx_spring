package com.movieAndgame.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class MovieReviewDto {
	private int review_id;
	
	@NotBlank(message="제목은 꼭 입력하세요")
	private String title;
	private String writer;
	
	@Size(min=10, max=300, message="최소 10자 이상 작성하세요")
	private String content;
	private LocalDateTime write_date;
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getWrite_date() {
		return write_date;
	}
	public void setWrite_date(LocalDateTime write_date) {
		this.write_date = write_date;
	}
}
	