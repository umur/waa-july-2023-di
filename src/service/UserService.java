package service;

import annotation.MyAutowired;

public class UserService {
    @MyAutowired
    UserRepository userRepository;

    @Override
    public String toString() {
        return "UserService [userRepository=" + userRepository + "]";
    }
}
