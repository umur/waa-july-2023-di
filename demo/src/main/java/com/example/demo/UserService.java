package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @MyInject
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void doSomething() {
        userRepository.saveUser("John");
    }
}
