package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		UserService userService = new UserService();

		Container container = new Container();
		container.registerDependency(UserRepository.class);

		MyDependencyInjector dependencyInjector = new MyDependencyInjector(container);
		dependencyInjector.injectDependencies(userService);

		// Verify dependency injection
		UserRepository userRepository = userService.getUserRepository();
		if (userRepository != null) {
			System.out.println("UserRepository dependency injected successfully");
		} else {
			System.out.println("Failed to inject UserRepository dependency");
		}
	}
}
