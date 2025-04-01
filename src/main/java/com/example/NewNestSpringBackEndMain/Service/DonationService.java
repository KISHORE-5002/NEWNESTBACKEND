package com.example.NewNestSpringBackEndMain.Service;

import com.example.NewNestSpringBackEndMain.Module.Donation;
import com.example.NewNestSpringBackEndMain.Repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    public Donation processDonation(Donation donation) {
        // Additional validation/business logic can be added here
        return donationRepository.save(donation);
    }
}