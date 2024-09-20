package com.example.demo.freatures.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.features.from.Form;
import com.example.demo.features.from.FormRepository;
@Service
public class ContactService {
	@Autowired
    private ContactRepository contactRepository;

    public void ContactForm(Contact form) {
        contactRepository.save(form);
    }
}
