public class UserService {
    @MyCustomInjector
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
