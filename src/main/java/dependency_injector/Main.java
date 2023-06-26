package dependency_injector;

import test.UserService;

public class Main {

    public static void main(String[] args) {
//        dependency_injector.Container.registerDependency(test.UserRepository.class);

        MyDependencyInjector dependencyInjector = new MyDependencyInjector();
        UserService userService = new UserService();

        dependencyInjector.getDependencies();
        dependencyInjector.injectDependency(userService);
        dependencyInjector.injectDependency(userService.userRepository);

        userService.print();

        // We can see that the User Repository is instantiated since it prints hello world without being initialized.

    }
}
