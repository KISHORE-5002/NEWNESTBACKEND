package com.example.NewNestSpringBackEndMain.Module;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "child_care")
public class ChildCare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String education;

    @Column(name = "medical_condition", nullable = false)
    private String medicalCondition;

    @Column(nullable = false)
    private boolean consent;

    @Column(name = "submission_date")
    private LocalDateTime submissionDate = LocalDateTime.now();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }
    public String getMedicalCondition() { return medicalCondition; }
    public void setMedicalCondition(String medicalCondition) { this.medicalCondition = medicalCondition; }
    public boolean isConsent() { return consent; }
    public void setConsent(boolean consent) { this.consent = consent; }
    public LocalDateTime getSubmissionDate() { return submissionDate; }
    public void setSubmissionDate(LocalDateTime submissionDate) { this.submissionDate = submissionDate; }
}