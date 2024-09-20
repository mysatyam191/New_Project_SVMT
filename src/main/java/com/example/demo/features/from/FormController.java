package com.example.demo.features.from;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.security.User;

@Controller
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/register")
    public String registerForm(@ModelAttribute User user) {
        formService.registerForm(user);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
