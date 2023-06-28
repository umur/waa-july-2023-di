import dependencyInjection.Inject;

public class UserService {
    @Inject
    private UserRepository userRepository;
    public UserService(){
        System.out.println("User service in container");
    }

}
