package cs545.waa;

import java.util.logging.Logger;

// EmailService.java
public class EmailService {
    @cs545.waa.Inject
    private cs545.waa.UserRepository userRepository;

    @cs545.waa.Inject
    private Logger logger;

    public void sendEmail(String message) {
        // Use the injected dependencies
        if (userRepository != null) {
            // Perform user-related operations
            System.out.println("UserRepository is injected successfully");
        }

        if (logger != null) {
            // Log the message
//            logger.log(message);
        }

        // Send the email
        System.out.println("Sending email: " + message);
    }
}

