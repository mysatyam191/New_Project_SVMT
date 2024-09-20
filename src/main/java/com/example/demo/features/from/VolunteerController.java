package com.example.demo.features.from;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.security.Role;
import com.example.demo.security.RoleService;
import com.example.demo.security.User;
import com.example.demo.security.UserService;

@Controller
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/volunteer/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("volunteer", new Volunteer());
        return "volunteerForm";
    }

    @PostMapping("/volunteer/register")
    public String registerVolunteer(@ModelAttribute("volunteer") Volunteer volunteer) {

        // Mapping/Convert Volunteer Object to User Object
        User user = new User();
        user.setFirstname(volunteer.getFirstName());
        user.setLastname(volunteer.getLastName());
        user.setUsername(volunteer.getUsername());
        user.setPassword(volunteer.getPassword());

        List<Role> roles = roleService.getRoles(); // Get all roles from roles table

        // Finding Volunteer Role
        Role role = roles.stream()
                .filter(r -> r.getDescription().equals("ROLE_VOLUNTEER"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        // Adding role to user object
        user.setRoles(roleSet);
        userService.save(user); // Saves the volunteer details to user table

        volunteerService.registerVolunteer(volunteer);
        return "redirect:/success2";
    }

    @GetMapping("/success2")
    public String showLoginPage() {
        return "success2";  // Corresponds to Volunteer_login.html in templates folder
    }

    @GetMapping("/volunteer/login")
    public String VolunteerPage() {
        return "Volunteer_login";  // Fix the URL mapping here
    }

    @PostMapping("/login/volunteer")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Validate credentials
        boolean isValidUser = volunteerService.validateVolunteer(username, password);

        if (isValidUser) {
            return "redirect:/index"; // Redirect to home page on successful login
        } else {
            return "redirect:/login/volunteer?error"; // Redirect back to login page with an error message
        }
    }
}
