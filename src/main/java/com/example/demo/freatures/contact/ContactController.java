package com.example.demo.freatures.contact;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.features.from.Form;
import com.example.demo.features.from.FormService;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public String showContactForm(Model model) {
    	model.addAttribute("form", new Contact());
    	return "contact";
    }
    @PostMapping("/submitted")
    public String ContactForm(@ModelAttribute Contact form) {
        contactService.ContactForm(form);
        return "redirect:/submitted";
    }
   
    @GetMapping("/submitted")
    public String success() {
        return "submitted";
    }


   


}
