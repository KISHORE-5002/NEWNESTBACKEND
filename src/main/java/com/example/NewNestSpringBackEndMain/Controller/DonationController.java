package com.example.NewNestSpringBackEndMain.Controller;

import com.example.NewNestSpringBackEndMain.Module.Donation;
import com.example.NewNestSpringBackEndMain.Service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/donations")
@CrossOrigin(origins = "http://localhost:3000")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping
    public ResponseEntity<?> createDonation(@Validated @RequestBody Donation donation) {
        try {
            // Additional validation for credit card payments
            if ("creditCard".equals(donation.getPaymentMethod()) &&
                    (donation.getCardNumber() == null || donation.getCardNumber().trim().isEmpty())) {
                return ResponseEntity.badRequest().body("Card number is required for credit card payments");
            }

            Donation processedDonation = donationService.processDonation(donation);
            return ResponseEntity.ok(processedDonation);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error processing donation: " + e.getMessage());
        }
    }
}
