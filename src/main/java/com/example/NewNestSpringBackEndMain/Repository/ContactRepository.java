package com.example.NewNestSpringBackEndMain.Repository;


import com.example.NewNestSpringBackEndMain.Module.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // CRUD operations provided by Spring Data JPA
}