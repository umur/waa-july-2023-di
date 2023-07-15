package service;
import my_annotations.Inject;
import repository.UserRepository;

public class UserService {
    @Inject
    private UserRepository userRepository;

    public void registerUser(String name) {
        userRepository.persistUser(name);
    }
}