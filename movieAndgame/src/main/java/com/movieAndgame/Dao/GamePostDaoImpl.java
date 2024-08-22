package com.movieAndgame.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.GamePostDto;
import com.movieAndgame.Dto.MovieReviewDto;





@Mapper
public interface GamePostDaoImpl {
	public int postSave(GamePostDto gamePostDto);
	
	public List<GamePostDto> findAll();

	public GamePostDto findById(int id);

}
