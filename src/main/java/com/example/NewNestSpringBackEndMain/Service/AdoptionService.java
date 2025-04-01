package com.example.NewNestSpringBackEndMain.Service;

import com.example.NewNestSpringBackEndMain.Module.Adoption;
import com.example.NewNestSpringBackEndMain.Repository.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionService {

    @Autowired
    private AdoptionRepository adoptionRepository;

    public Adoption processAdoption(Adoption adoption) {
        if (!adoption.isConsent()) {
            throw new IllegalArgumentException("Consent is required for adoption");
        }
        return adoptionRepository.save(adoption);
    }
}