package com.example.NewNestSpringBackEndMain.Repository;

import com.example.NewNestSpringBackEndMain.Module.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
    List<Child> findByStatus(Child.Status status);
}