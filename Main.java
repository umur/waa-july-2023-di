public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        MyService myService = new MyService();

        Container container = new Container();

        UserRepository userRepository = new UserRepository();
        MyRepository1 myRepository1 = new MyRepository1();
        MyRepository2 myRepository2 = new MyRepository2();

        container.registerDependency(UserRepository.class, userRepository);
        container.registerDependency(MyRepository1.class, myRepository1);
        container.registerDependency(MyRepository2.class, myRepository2);

        MyDependencyInjector myDependencyInjector = new MyDependencyInjector(container);
        myDependencyInjector.injectDependencies(userService);
        myDependencyInjector.injectDependencies(myService);

        if (userService.getUserRepository() == userRepository){
            System.out.println("User service ===> DI successful");
        } else {
            System.out.println("User service ===> DI failed");
        }

        if (myService.getMyRepository1() == myRepository1 && myService.getMyRepository2() == myRepository2){
            System.out.println("My custom service ===> DI successful");
        } else {
            System.out.println("My custom service ===> DI failed");
        }
    }
}
