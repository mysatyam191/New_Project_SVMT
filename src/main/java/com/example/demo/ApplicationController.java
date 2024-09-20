package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

	@GetMapping("index.html")
	public String HomePage() {
		return "index";
	}
	@GetMapping("HTML/contact.html")
	public String contactPage() {
		return "contact";
	}
	@GetMapping("HTML/submitted.html")
	public String SubmitPage() {
		return "submitted";
	}
	@GetMapping("HTML/About.html")
	public String AboutPage() {
		return "about";
	}
	@GetMapping("HTML/join_us.html")
	public String JoinPage() {
		return "join_us";
	}
	@GetMapping("HTML/Vision_Mission.html")
	public String VisionPage() {
		return "Vision_Mission";
	}
	@GetMapping("HTML/team.html")
	public String teamPage() {
		return "team";
	}
	
	@GetMapping("HTML/volunteerForm.html")
	public String volunteerFormPage() {
		return "volunteerForm";
	}
	
	@GetMapping("HTML/features.html")
	public String FeaturesPage() {
		return "features";
	}
	@GetMapping("HTML/signup_form.html")
	public String RegistrationPage() {
		return "signup_form";
	}

	@GetMapping("HTML/success.html")
	public String ReturnPage() {
		return "success";
	}
	@GetMapping("HTML/success2.html")
	public String ReturnPage2(){
		return "success2";
	}
	
	@GetMapping("HTML/upload.html")
	public String ImageUploadPage() {
		return "upload";
	}
	@GetMapping("HTML/gallery.html")
	public String ImageGalleryPage() {
		return "gallery";
	}
	
	@GetMapping("admin")
	public String adminPage() {
		return "admin";
	}
	
	@GetMapping("/About.html")
	public String aboutPage() {
		return "About.html";
	}

	@GetMapping("volunteer")
	public String volunteerPage() {
		return "volunteer";
	}

	@GetMapping("user")
	public String userPage() {
		return "user";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}	
	
	@GetMapping("/register-user")
	public String register() {
		return "register";
	}

	@GetMapping("/accessDenied")
	public String fail(){
		return "accessDenied";
	}
	
}
