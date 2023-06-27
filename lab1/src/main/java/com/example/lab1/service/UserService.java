package com.example.lab1.service;

import com.example.lab1.controller.InjectDependency;
import com.example.lab1.repository.UserRepository;

public class UserService {
    @InjectDependency
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
