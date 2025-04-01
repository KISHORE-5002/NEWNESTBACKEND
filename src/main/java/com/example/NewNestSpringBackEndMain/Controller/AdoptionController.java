package com.example.NewNestSpringBackEndMain.Controller;

import com.example.NewNestSpringBackEndMain.Module.Adoption;
import com.example.NewNestSpringBackEndMain.Service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/adopt")
@CrossOrigin(origins = "http://localhost:3000")
public class AdoptionController {

    @Autowired
    private AdoptionService adoptionService;

    @PostMapping("/add")
    public ResponseEntity<?> addAdoption(@Validated @RequestBody Adoption adoption) {
        try {
            Adoption processedAdoption = adoptionService.processAdoption(adoption);
            return ResponseEntity.ok(processedAdoption);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error processing adoption: " + e.getMessage());
        }
    }
}