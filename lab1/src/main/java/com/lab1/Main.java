package com.lab1;

/**
 *Test the Dependency Injection:
 *
 * In the main method of your application, create an instance of the "UserService" class.
 * Create an instance of the "Container" class and register the "UserRepository" as a dependency.
 * Create an instance of the "MyDependencyInjector" class and call the "injectDependencies" method, passing the "UserService" instance.
 * Verify that the "UserService" object has the "UserRepository" dependency properly injected.
 * */
public class Main {
    public static void main(String[] args) {
        // Create an instance of the Container class
        Container container = new Container();

        // Register UserRepository as a dependency
        container.registerDependency(UserRepository.class, new UserRepository());

        // Resolve UserRepository from the container
        UserRepository userRepository = (UserRepository) container.resolveDependency(UserRepository.class);

        // Create an instance of UserService and pass the UserRepository dependency
        UserService userService = new UserService(userRepository);

        // Create an instance of the MyDependencyInjector class
        MyDependencyInjector injector = new MyDependencyInjector(container);

        // Perform dependency injection on the userService object
        injector.injectDependencies(userService);

        // Verify that the dependency is properly injected
        userService.createUser("Amrit Bhattarai");
    }
}
