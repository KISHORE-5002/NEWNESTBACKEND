package com.example.NewNestSpringBackEndMain.Controller;

import com.example.NewNestSpringBackEndMain.Module.Admission;
import com.example.NewNestSpringBackEndMain.Service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admissions")
@CrossOrigin(origins = "http://localhost:3000")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @PostMapping("/add")
    public ResponseEntity<?> addAdmission(@RequestBody Admission admission) {
        try {
            if (!admission.isConsent()) {
                return ResponseEntity.badRequest().body("Consent is required");
            }

            Admission savedAdmission = admissionService.saveAdmission(admission);
            return ResponseEntity.ok(savedAdmission);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error saving admission: " + e.getMessage());
        }
    }
}