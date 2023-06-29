public class UserService {

    @Inject
    private UserRepository repository;

    @Inject
    private EmailSender emailSender;

    public UserRepository getRepository() {
        return repository;
    }

    public EmailSender getEmailSender() {
        return emailSender;
    }
}
