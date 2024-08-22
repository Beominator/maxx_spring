package com.movieAndgame.control;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMember;
import com.movieAndgame.Dto.GamePostDto;
import com.movieAndgame.Dto.MovieReviewDto;
import com.movieAndgame.service.GamePostService;



@Controller
@RequestMapping("/gamePost")
public class GamePostControl {
	@Autowired
	private GamePostService postService;
	
	// 글 내용 작성 후 저장 요청
	@GetMapping("/write")
	public String postWrite(@Valid GamePostDto gamePostDto, BindingResult bind, Model model) {
		if(bind.hasErrors()) {	// form 데이터 값이 유효하지 않다면
			return "game/post/write";
		}
		postService.save(gamePostDto);
		return "redirect:/gamePost/m";
	}

	@GetMapping("/m")
	public String postMain(Model model) {
		
		List<GamePostDto> list = postService.postlist();
		model.addAttribute("postList", list);
		
		return "game/post/index";
	}
	
	
	
	// 리뷰작성 페이지 요청
	@GetMapping("/postWrite")
	public String write(Model model, HttpSession session) {
		
		GamePostDto dto = new GamePostDto();
		
		if(session.getAttribute("user") == null) {	// 로그인 상태가 아니면 로그인 페이지로 이동
			return "redirect:/game/login";
			
		}
		
		String name = ((GameMember)session.getAttribute("user")).getName();
		dto.setWriter(name);
		
		model.addAttribute("gamePostDto",dto);
		
		return "game/post/write";
		}
		
		@GetMapping("/post/{id}")
		public String post(@PathVariable("id") int id, Model model) {
			
			GamePostDto dto = postService.findById(id);
			model.addAttribute("gamePostDto", dto);
			
			return "game/post/detail";
		}
	
}
