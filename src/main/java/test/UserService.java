package test;

import dependency_injector.AutoWired;

public class UserService {
    @AutoWired
    public UserRepository userRepository;
    public void print(){
        userRepository.print();
        userRepository.dependency.print();
    }
}
