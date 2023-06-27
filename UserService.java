public class UserService {
    @Inject
    private UserRepository userRepository;

    public UserRepository getUserRepository(){
        return userRepository;
    }
}
