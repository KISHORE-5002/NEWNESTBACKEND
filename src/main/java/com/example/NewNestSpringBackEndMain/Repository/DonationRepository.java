package com.example.NewNestSpringBackEndMain.Repository;

import com.example.NewNestSpringBackEndMain.Module.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
}