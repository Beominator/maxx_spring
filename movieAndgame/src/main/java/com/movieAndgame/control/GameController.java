package com.movieAndgame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMember;
import com.movieAndgame.Dto.MovieMember;
import com.movieAndgame.service.GameMemberService;


@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	private GameMemberService gameMemberService;
	
	@GetMapping("/index")
	public String Home(Model model) {
		
		return "game/index";
	}
	
	@GetMapping("/login")
	public String loginHome(Model model) {
		
		model.addAttribute("member", new GameMember());
		
		return "game/member/login";
	}
	
	@GetMapping("/signUp")
	public String signup(Model model) {
		model.addAttribute("gameMember", new GameMember());
		return "game/member/join";
	}
	@PostMapping("/signUp")
	public String signUp(@Valid GameMember gameMember, 
			BindingResult bindingResult, Model model ) {
		
		if( bindingResult.hasErrors()) {
			System.out.println("유효하지 않은 값이 입력되었다.");
		
			return "game/member/join";
		}
		boolean isDup = gameMemberService.signUpSave(gameMember);
		if(isDup) {
			bindingResult.rejectValue("email", "error.email", "가입된 이메일입니다.");
			return "game/member/join";
		}
		
		return "redirect:/game/login";
	}
	
	@PostMapping("/signIn")
	public String signIn( GameMember member, HttpSession session, Model model) {
		
		GameMember user = gameMemberService.login(member);
		if(user==null) {
			model.addAttribute("member", member);
			model.addAttribute("fail","a");
			return "game/member/login";
		}
		session.setAttribute("user", user);
		
		return "redirect:/game/index";
	}
}
