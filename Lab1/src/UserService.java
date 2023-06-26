public class UserService {

    @MyAutoWired
    private UserRepository userRepository;

    public void print() {
        userRepository.print();
    }
}
