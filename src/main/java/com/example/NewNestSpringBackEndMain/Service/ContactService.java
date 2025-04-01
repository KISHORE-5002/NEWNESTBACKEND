package com.example.NewNestSpringBackEndMain.Service;

import com.example.NewNestSpringBackEndMain.Module.Contact;
import com.example.NewNestSpringBackEndMain.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }
}