
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void testUserService(){
        userRepository.here();
    }
}
