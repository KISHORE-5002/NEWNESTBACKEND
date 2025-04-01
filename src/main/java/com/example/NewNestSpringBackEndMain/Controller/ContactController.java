package com.example.NewNestSpringBackEndMain.Controller;

import com.example.NewNestSpringBackEndMain.Module.Contact;
import com.example.NewNestSpringBackEndMain.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    @Autowired
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addContact(@RequestBody Contact contact) {
        try {
            contactService.saveContact(contact);
            return ResponseEntity.ok("Contact form submitted successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error submitting contact form: " + e.getMessage());
        }
    }
}