package com.miu.lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Lab1Application {

    public static void main(String[] args) {

        UserService userService = new UserService();

        Container container = new Container();
        container.registerDependency(UserRepository.class);

        MyDependencyInjector injector = new MyDependencyInjector(container);
        injector.injectDependencies(userService);

        userService.sendMessage("John Doe", "say Hello");

    }

}
