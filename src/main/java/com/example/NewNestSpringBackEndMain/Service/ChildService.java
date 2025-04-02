package com.example.NewNestSpringBackEndMain.Service;

import com.example.NewNestSpringBackEndMain.Module.Child;
import com.example.NewNestSpringBackEndMain.Repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildService {

    @Autowired
    private final ChildRepository childRepository;

    private ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    public static ChildService createChildService(ChildRepository childRepository) {
        return new ChildService(childRepository);
    }

    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }

    public Optional<Child> getChildById(Long id) {
        return childRepository.findById(id);
    }

    public List<Child> getChildrenByStatus(Child.Status status) {
        return childRepository.findByStatus(status);
    }

    public Child saveChild(Child child) {
        return childRepository.save(child);
    }

    public void deleteChild(Long id) {
        childRepository.deleteById(id);
    }

    public long getTotalChildren() {
        return childRepository.count();
    }

    public long getAvailableChildrenCount() {
        return childRepository.findByStatus(Child.Status.available).size();
    }
}