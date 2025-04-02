package com.example.NewNestSpringBackEndMain.Service;

import com.example.NewNestSpringBackEndMain.Module.Contact;
import com.example.NewNestSpringBackEndMain.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContactMessage(Contact contact) {
        if (!contact.isAgreedToTerms()) {
            throw new IllegalArgumentException("User must agree to terms");
        }
        return contactRepository.save(contact);
    }
}