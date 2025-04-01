package com.example.NewNestSpringBackEndMain.Service;

import com.example.NewNestSpringBackEndMain.Module.ChildCare;
import com.example.NewNestSpringBackEndMain.Repository.ChildCareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildCareService {

    @Autowired
    private ChildCareRepository childCareRepository;

    public ChildCare saveChildCareForm(ChildCare childCare) {
        if (!childCare.isConsent()) {
            throw new IllegalArgumentException("Consent is required");
        }
        return childCareRepository.save(childCare);
    }
}