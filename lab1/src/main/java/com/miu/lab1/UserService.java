package com.miu.lab1;

public class UserService {

    @Inject
    private UserRepository userRepository;

    public void sendMessage(String username,String message) {
        userRepository.sendMessage(username,message);
    }
}
