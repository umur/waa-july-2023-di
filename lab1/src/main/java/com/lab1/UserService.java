package com.lab1;

/**
 Define the Classes to be Injected:

 Createed a class called "UserService" with a private field of type "UserRepository".
 Annotate the "UserService" class field with your custom injection annotation.
 * */
class UserService {
    @MyInject
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void createUser(String username) {
        userRepository.saveUser(username);
    }
}
