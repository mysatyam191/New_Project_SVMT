package com.example.demo.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

	@Autowired private UserService userService;

	 @Autowired
	    private RoleService roleService;

	//Get All Users
	@GetMapping("users")
	public String findAll(Model model){
		model.addAttribute("users", userService.findAll());
		return "user";
	}

	@RequestMapping("users/findById")
	@ResponseBody
	public User findById(Integer id)
	{
		return userService.findById(id);
	}

	//Modified method to Add a new user User
	@PostMapping(value="users/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		List<Role> roles = roleService.getRoles(); //Get all roles from roles table
        /* Finding Volunteer Role */
        Role role = roles.stream()
                .filter(r -> r.getDescription().equals("ROLE_USER"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        /* Adding role to user object */
        user.setRoles(roleSet);

		userService.save(user);	
		
		RedirectView  redirectView= new RedirectView("/login",true);
		
	    redir.addFlashAttribute("message",	"You successfully registered! You can now login");
	        
	    return redirectView;				
	}
	
}
