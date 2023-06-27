package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    public void saveUser(String name) {
        System.out.println("Saving user: " + name);
    }
}
