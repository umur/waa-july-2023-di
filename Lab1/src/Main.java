// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Container container = new Container();
        container.registerDependency(UserRepository.class);
        MyDependencyInjector myDependencyInjector = new MyDependencyInjector(container);
        myDependencyInjector.injectDependencies(userService);
        userService.print();

        testAnotherClass();
    }

    private static void testAnotherClass() {
        AnotherClass anotherClass = new AnotherClass();
        Container container = new Container();
        container.registerDependency(UserRepository.class);
        container.registerDependency(UserService.class);
        MyDependencyInjector myDependencyInjector = new MyDependencyInjector(container);
        myDependencyInjector.injectDependencies(anotherClass);
        anotherClass.print();
    }
}