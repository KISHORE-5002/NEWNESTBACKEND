package com.example.NewNestSpringBackEndMain.Controller;

import com.example.NewNestSpringBackEndMain.Module.Contact;
import com.example.NewNestSpringBackEndMain.Repository.ContactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addContact(@RequestBody Contact contact) {
        try {
            contactRepository.save(contact);
            return ResponseEntity.ok("Contact message saved successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Failed to save contact message");
        }
    }
}