package com.waa_lab1;

class UserService {
    @Inject
    private UserRepository userRepository;
    public void performAction() {
        userRepository.saveUser();
    }
}
