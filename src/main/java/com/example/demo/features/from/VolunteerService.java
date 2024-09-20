package com.example.demo.features.from;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Volunteer registerVolunteer(Volunteer volunteer) {
        // Encrypt the password before saving it to the database
        volunteer.setPassword(passwordEncoder.encode(volunteer.getPassword()));
        return volunteerRepository.save(volunteer);
    }
    
    public boolean validateVolunteer(String username, String password) {
        Volunteer volunteer = volunteerRepository.findByUsername(username);
        if (volunteer != null) {
            return passwordEncoder.matches(password, volunteer.getPassword());
        }
        return false;
    }

	
}
