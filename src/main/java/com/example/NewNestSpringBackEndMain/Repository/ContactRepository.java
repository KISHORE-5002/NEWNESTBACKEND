package com.example.NewNestSpringBackEndMain.Repository;

import com.example.NewNestSpringBackEndMain.Module.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}