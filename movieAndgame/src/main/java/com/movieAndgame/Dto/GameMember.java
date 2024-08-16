package com.movieAndgame.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class GameMember {
	@NotEmpty(message="이메일을 입력하세요")
	private String email;
	
	
	@Pattern(regexp="^[a-zA-Z0-9]*$", message="영어 대소문자와 숫자만 입력하세요")
	private String password;
	
	@NotNull(message="닉네임은 필수 입니다.")
	private String nick_name;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nick_name;
	}
	public void setNickName(String nickName) {
		this.nick_name = nickName;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
