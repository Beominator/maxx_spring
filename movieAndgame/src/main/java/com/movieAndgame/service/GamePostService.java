package com.movieAndgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GamePostDaoImpl;
import com.movieAndgame.Dto.GamePostDto;
import com.movieAndgame.Dto.MovieReviewDto;

@Service
public class GamePostService {

	
	@Autowired
	private GamePostDaoImpl gamePostDao;
	
	public List<GamePostDto> postlist(){
		return gamePostDao.findAll();
	}
	
	public void save(GamePostDto gamePostDto) {
		gamePostDao.postSave(gamePostDto);
	}

	public GamePostDto findById(int id) {
		
		return gamePostDao.findById(id);
	}
}
