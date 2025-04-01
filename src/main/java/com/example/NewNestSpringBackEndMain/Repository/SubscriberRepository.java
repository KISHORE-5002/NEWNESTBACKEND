package com.example.NewNestSpringBackEndMain.Repository;

import com.example.NewNestSpringBackEndMain.Module.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
    boolean existsByEmail(String email);
}