public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Container container = new Container();
        UserRepository userRepository = new UserRepository();
        container.registerDependency(UserRepository.class, userRepository);
        MyDependencyInjector myDependencyInjector = new MyDependencyInjector(container);
        myDependencyInjector.injectDependencies(userService);

        if (userService.getUserRepository() == userRepository){
            System.out.println("DI successful");
        } else {
            System.out.println("DI failed");
        }
    }
}
