package com.example.NewNestSpringBackEndMain.Controller;


import com.example.NewNestSpringBackEndMain.Module.Child;
import com.example.NewNestSpringBackEndMain.Service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/children")

@CrossOrigin(origins = "http://localhost:3000")// Allow requests from any origin without authentication
public class ChildController {

    private final ChildService childService;

    @Autowired
    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping
    public ResponseEntity<List<Child>> getAllChildren() {
        List<Child> children = childService.getAllChildren();
        return new ResponseEntity<>(children, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Child> getChildById(@PathVariable Long id) {
        return childService.getChildById(id)
                .map(child -> new ResponseEntity<>(child, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Child>> getChildrenByStatus(@PathVariable String status) {
        try {
            Child.Status childStatus = Child.Status.valueOf(status);
            List<Child> children = childService.getChildrenByStatus(childStatus);
            return new ResponseEntity<>(children, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Child> createChild(@RequestBody Child child) {
        Child savedChild = childService.saveChild(child);
        return new ResponseEntity<>(savedChild, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Child> updateChild(@PathVariable Long id, @RequestBody Child child) {
        return childService.getChildById(id)
                .map(existingChild -> {
                    child.setId(id);
                    Child updatedChild = childService.saveChild(child);
                    return new ResponseEntity<>(updatedChild, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChild(@PathVariable Long id) {
        return childService.getChildById(id)
                .map(child -> {
                    childService.deleteChild(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Long>> getChildrenStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalChildren", childService.getTotalChildren());
        stats.put("availableChildren", childService.getAvailableChildrenCount());
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }
}