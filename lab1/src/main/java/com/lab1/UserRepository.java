package com.lab1;

// Classes to be injected
class UserRepository {
    public void saveUser(String username) {
        System.out.println("Saving user: " + username);
    }
}
