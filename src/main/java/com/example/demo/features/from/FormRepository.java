package com.example.demo.features.from;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.security.User;

public interface FormRepository extends JpaRepository<User, Integer> {
   
}
