public class UserService {
    @MyAutowired
     UserRepository userRepository;

    public double averageUserSession(){
        return userRepository.getAverageUserSession();
    }

    public UserService() {

    }
}
