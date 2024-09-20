package com.example.demo.features.from;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.security.User;
import com.example.demo.security.UserRepository;

@Service
public class FormService {

    @Autowired
    private UserRepository userRepository;

    	@Autowired private BCryptPasswordEncoder encoder;


    public void registerForm(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
