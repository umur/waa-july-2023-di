// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        UserRepository userRepository = new UserRepository();
        container.registerDependency(UserRepository.class, userRepository);

        UserService userService = new UserService();
        MyDependencyInjector dependencyInjector = new MyDependencyInjector(container);
        dependencyInjector.injectDependencies(userService);

        assert userService.getUserRepository() != null: "The \"UserService\" object dose not have the \"UserRepository\" dependency properly injected.";

        System.out.println("Assertion passed!");
    }
}