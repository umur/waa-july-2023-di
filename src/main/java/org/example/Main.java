package org.example;

import org.example.DI.Container;
import org.example.DI.MyDependencyInjector;

public class Main {
    public static void main(String[] args) {

        Container container = new Container();

        // Register dependencies
        container.registerDependency(UserRepository.class);
        container.registerDependency(AnotherDependency.class);


        MyDependencyInjector injector = new MyDependencyInjector(container);

        UserService userService = new UserService();
        AnotherService anotherService = new AnotherService();

        // Inject dependencies into UserService
        injector.injectDependencies(userService);
        injector.injectDependencies(anotherService);

        userService.performOperation();
        anotherService.performOperation();
    }
}