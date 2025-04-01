package com.example.NewNestSpringBackEndMain.Controller;

import com.example.NewNestSpringBackEndMain.Service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
public class NewsletterController {

    @Autowired
    private NewsletterService newsletterService;

    @PostMapping("/add")
    public ResponseEntity<String> subscribe(@RequestBody String email) {
        try {
            String result = newsletterService.subscribeEmail(email);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Subscription failed: " + e.getMessage());
        }
    }
}
