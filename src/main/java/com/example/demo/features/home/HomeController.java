package com.example.demo.features.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Autowired
	HomeService homeService;
	
	@GetMapping("/")
	public String home(Model model) {
		String about = homeService.about();
		model.addAttribute("about", about);
		return "index.html";
	}
	
}
