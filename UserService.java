package cs545.waa;

public class UserService {
    @cs545.waa.Inject
    private cs545.waa.UserRepository userRepository;

    public cs545.waa.UserRepository getUserRepository() {
        userRepository.printMe();
        return userRepository;
    }
}
