package com.example.NewNestSpringBackEndMain.Controller;

import com.example.NewNestSpringBackEndMain.Module.ChildCare;
import com.example.NewNestSpringBackEndMain.Service.ChildCareService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/childcare")
@CrossOrigin(origins = "http://localhost:3000")
public class ChildCareController {

    @Autowired
    private ChildCareService childCareService;

    @PostMapping("/add")
    public ResponseEntity<?> addChildCare(@Valid @RequestBody ChildCare childCare) {
        try {
            ChildCare savedForm = childCareService.saveChildCareForm(childCare);
            return ResponseEntity.ok(savedForm);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error saving form: " + e.getMessage());
        }
    }
}