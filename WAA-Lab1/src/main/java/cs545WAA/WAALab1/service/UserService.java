package cs545WAA.WAALab1.service;

import cs545WAA.WAALab1.controller.InjectDependencies;
import cs545WAA.WAALab1.repository.UserRepository;

public class UserService {
@InjectDependencies
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
