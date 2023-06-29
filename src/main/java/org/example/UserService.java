package org.example;

import org.example.DI.Inject;

public class UserService {
    @Inject
    private UserRepository userRepository;
    public void performOperation() {
        userRepository.saveUser();

    }
}
