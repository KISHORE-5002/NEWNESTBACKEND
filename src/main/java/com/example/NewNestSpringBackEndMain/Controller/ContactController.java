package com.example.NewNestSpringBackEndMain.Controller;

import com.example.NewNestSpringBackEndMain.Module.Contact;
import com.example.NewNestSpringBackEndMain.Service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/add")
    public ResponseEntity<?> addContact(@Valid @RequestBody Contact contact) {
        try {
            Contact savedContact = contactService.saveContactMessage(contact);
            return ResponseEntity.ok(savedContact);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error saving contact: " + e.getMessage());
        }
    }
}