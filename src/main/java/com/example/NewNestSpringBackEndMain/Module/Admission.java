package com.example.NewNestSpringBackEndMain.Module;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;

@Entity
@CrossOrigin(origins = "http://localhost:8080/api/admissions/add")
@Table(name = "admissions")
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String gender;
    private String address;
    private String vaccinated;
    private String specialAssistance;
    private String allergies;
    private String previousSchool;
    private String currentGrade;
    private boolean consent;

    @Column(name = "submission_date")
    private LocalDateTime submissionDate = LocalDateTime.now();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getVaccinated() { return vaccinated; }
    public void setVaccinated(String vaccinated) { this.vaccinated = vaccinated; }
    public String getSpecialAssistance() { return specialAssistance; }
    public void setSpecialAssistance(String specialAssistance) { this.specialAssistance = specialAssistance; }
    public String getAllergies() { return allergies; }
    public void setAllergies(String allergies) { this.allergies = allergies; }
    public String getPreviousSchool() { return previousSchool; }
    public void setPreviousSchool(String previousSchool) { this.previousSchool = previousSchool; }
    public String getCurrentGrade() { return currentGrade; }
    public void setCurrentGrade(String currentGrade) { this.currentGrade = currentGrade; }
    public boolean isConsent() { return consent; }
    public void setConsent(boolean consent) { this.consent = consent; }
    public LocalDateTime getSubmissionDate() { return submissionDate; }
    public void setSubmissionDate(LocalDateTime submissionDate) { this.submissionDate = submissionDate; }
}
