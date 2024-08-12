package com.example.bookTest.Dto;

public class InfoDto {	// home.jsp의 form데이터 받기
	private String uName;
	private String uBirth;
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuBirth() {
		return uBirth;
	}
	public void setuBirth(String uBirth) {
		this.uBirth = uBirth;
	}
}
