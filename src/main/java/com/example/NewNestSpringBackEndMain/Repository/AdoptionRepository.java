package com.example.NewNestSpringBackEndMain.Repository;

import com.example.NewNestSpringBackEndMain.Module.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
}