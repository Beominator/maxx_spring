package com.movieAndgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GameMemberDao;
import com.movieAndgame.Dto.GameMember;
import com.movieAndgame.Dto.MovieMember;




@Service
public class GameMemberService {

	@Autowired
	private GameMemberDao gameMemberDao;
	
	public GameMember login(GameMember gameMember) {
		
		return gameMemberDao.login(gameMember);
	}
	
	// 회원가입 데이터베이스 저장
	public boolean signUpSave(GameMember gameMember) {
		
		List<String> emailList = gameMemberDao.findAllEmail();
		if(emailList.contains(gameMember.getEmail()))
			return true;
		gameMemberDao.insert(gameMember);
		return false;
	}

	

}
