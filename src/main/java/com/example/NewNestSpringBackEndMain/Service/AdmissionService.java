package com.example.NewNestSpringBackEndMain.Service;

import com.example.NewNestSpringBackEndMain.Module.Admission;
import com.example.NewNestSpringBackEndMain.Repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdmissionService {

    @Autowired
    private AdmissionRepository admissionRepository;

    public Admission saveAdmission(Admission admission) {
        return admissionRepository.save(admission);
    }
}