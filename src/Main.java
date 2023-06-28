public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();
        Container containerInstnce = Container.INSTANCE;
        containerInstnce.registerDependency(UserRepository.class);
        DependencyInjector dependencyInjector = MyDependencyInjector.INSTANCE;
        try {
            dependencyInjector.injectDependencies(userService);
            userService.testUserService();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}