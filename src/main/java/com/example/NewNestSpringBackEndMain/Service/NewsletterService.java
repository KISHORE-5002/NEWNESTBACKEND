package com.example.NewNestSpringBackEndMain.Service;

import com.example.NewNestSpringBackEndMain.Module.Subscriber;
import com.example.NewNestSpringBackEndMain.Repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsletterService {

    @Autowired
    private SubscriberRepository subscriberRepository;

    public String subscribeEmail(String email) {
        if (subscriberRepository.existsByEmail(email)) {
            return "You're already subscribed!";
        }

        Subscriber newSubscriber = new Subscriber();
        newSubscriber.setEmail(email);
        subscriberRepository.save(newSubscriber);

        return "Thank you for subscribing!";
    }
}