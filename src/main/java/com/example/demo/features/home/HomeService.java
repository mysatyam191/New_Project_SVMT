package com.example.demo.features.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeService {

    @Autowired
    private HomeRepository homeRepository;

    public String about() {
        // Return the value if present, otherwise return "Default about information"
        return homeRepository.findById("about")
                             .map(Home::getValue)
                             .orElse("This is the edited information edited by Satyam kumar jha ");
    }
}
