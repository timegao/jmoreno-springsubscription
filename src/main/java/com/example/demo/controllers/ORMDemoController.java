package com.example.demo.controllers;

import com.example.demo.models.Subscription;
import com.example.demo.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/demo")
public class ORMDemoController {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @GetMapping(path="/subscribe")
    public @ResponseBody String addNewSubscription(@RequestParam String name
            , @RequestParam String email) {

        Subscription n = new Subscription();
        n.setName(name);
        n.setEmail(email);
        subscriptionRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/unsubscribe")
    public @ResponseBody String deleteNewSubscription(@RequestParam int id) {
        subscriptionRepository.deleteById(id);
        return "Deleted";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Subscription> getAllUsers() {
        return subscriptionRepository.findAll();
    }
}