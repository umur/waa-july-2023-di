package cs545.waa;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the Container class and register the UserRepository as a dependency
        cs545.waa.Container container = new cs545.waa.Container();
        container.registerDependency(cs545.waa.UserRepository.class);

        // Create an instance of the MyDependencyInjector class and call the injectDependencies method
        cs545.waa.DependencyInjector injector = new cs545.waa.MyDependencyInjector(container);

        // Create an instance of the UserService class
        cs545.waa.UserService userService = new cs545.waa.UserService();

        // Perform dependency injection on the UserService instance
        injector.injectDependencies(userService);

        // Verify that the UserService object has the UserRepository dependency properly injected
        cs545.waa.UserRepository userRepository = userService.getUserRepository();
        System.out.println("UserRepository dependency injected successfully: " + (userRepository != null));
    }
}

