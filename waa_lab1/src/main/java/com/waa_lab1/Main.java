package com.waa_lab1;
public class Main {
    public static void main(String[] args) {
        // Create an instance of the UserService class
        UserService userService = new UserService();

        // Create an instance of the Container class and register the UserRepository
        Container container = new Container();
        container.registerDependency(UserRepository.class);

        // Create an instance of the MyDependencyInjector class and inject dependencies into UserService
        MyDependencyInjector injector = new MyDependencyInjector(container);
        injector.injectDependencies(userService);

        // Verify that the UserService object has the UserRepository dependency properly injected
        userService.performAction();
    }
}
