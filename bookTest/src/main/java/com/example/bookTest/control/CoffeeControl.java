
package com.example.bookTest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.BookDto;
import com.example.bookTest.Dto.CoffeeDto;
import com.example.bookTest.service.CoffeeService;

@Controller
public class CoffeeControl {

	@Autowired
	private CoffeeService coffeeService;
	
	@GetMapping("/coffee")
	public ModelAndView home() {
		ModelAndView mv =new ModelAndView("coffee/index");
		
		List<CoffeeDto> list = coffeeService.selectAll();
		mv.addObject("list", list);
		
		return mv;
	}
	
	
	@GetMapping("/coffeeReg")
	public String write() {
		return "coffee/coffeForm";
	}
	
	@PostMapping("/coffeeSave")
	public String menuSave( @ModelAttribute CoffeeDto coffeeDto) {
		coffeeService.menuInsert(coffeeDto);		
		return "redirect:/coffee";
	}
	
	
	@GetMapping("/coffee/view")
	public ModelAndView view(@RequestParam("id") int id) {
		
		CoffeeDto dto = coffeeService.getMenu(id);
		return new ModelAndView("coffee/view").addObject("menu",dto);
	}
	
	
	@GetMapping("/coffee/delete")
	public String remove( @RequestParam("id") int id) {
		coffeeService.remove(id);
		return "redirect:/coffee";		
	}
	
	@GetMapping("coffee/update")
	public String update(@ModelAttribute CoffeeDto coffeeDto, @RequestParam("id") int id) {
		coffeeDto.setCoffee(id);
		coffeeService.update( coffeeDto );
		return "redirect:/coffee/view?id="+id;
	}
	
	
}
