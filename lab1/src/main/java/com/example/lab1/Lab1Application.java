package com.example.lab1;

import com.example.lab1.controller.InjectDependency;
import com.example.lab1.model.Container;
import com.example.lab1.model.MyDependencyInjector;
import com.example.lab1.repository.UserRepository;
import com.example.lab1.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab1Application implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(Lab1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        UserService userService = new UserService();


        Container container = new Container();
        container.registerDependency(UserRepository.class);


        MyDependencyInjector dependencyInjector = new MyDependencyInjector(container);
        dependencyInjector.injectDependencies(userService);


        UserRepository userRepository = userService.getUserRepository();
        System.out.println(userRepository);
    }





}
