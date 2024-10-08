package com.movieAndgame.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.MovieMember;
import com.movieAndgame.service.MovieMemberService;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieMemberService movieMemberService;
	
	// "/"은 localhost/movie/index 매핑이다.
	@GetMapping("/index")
	public String Home(Model model) {
		
		return "movie/index";
	}
	
	@GetMapping("/login")
	public String loginHome(Model model) {
		
		model.addAttribute("member", new MovieMember());
		
		return "movie/member/login";
	}
	
	// 회원가입 페이지 요청
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("movieMember", new MovieMember());
		return "movie/member/join";
	}
	
	// 회원가입 작성 후 요청
	@PostMapping("/signUp")
	public String signUp(@Valid MovieMember movieMember, 
			BindingResult bindingResult, Model model ) {
		
		if( bindingResult.hasErrors()) {
			System.out.println("유효하지 않은 값이 입력되었다.");
			System.out.println(bindingResult.hasFieldErrors("name"));
			System.out.println(bindingResult.hasFieldErrors("birthYear"));
			System.out.println(bindingResult.hasFieldErrors("birthMonth"));
			System.out.println(movieMember.getPassword());
			return "movie/member/join";
		}
		
		boolean isDup = movieMemberService.signUpSave(movieMember);
		
		if(isDup) {	// 이메일이 중복이라면 회원가입 페이지로 이동시킨다.
			bindingResult.rejectValue("email", "error.email", "가입된 이메일입니다.");
			return "movie/member/join";
		}
			
		
		return "redirect:/movie/login";
	}
	
	@PostMapping("/signIn")
	public String signIn( MovieMember member, HttpSession session, Model model) {
		// 로그인 처리 - 데이터베이스에 이메일과 비번이 일치하는지 확인하고
		// 일치하면 세션 만들고 첫 페이지로 이동, 일치하지 않으면 로그인 페이지로 돌려보내기
		
		MovieMember user = movieMemberService.login(member);
		if(user==null) {
			model.addAttribute("member", member);
			model.addAttribute("fail","a");
			return "movie/member/login";
		}
		session.setAttribute("user", user);
		
		return "redirect:/movie/index";
	}
	
	@GetMapping("/logout")
	public String out(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/movie/index";
	}
}
