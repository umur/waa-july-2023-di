import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        Container.registerDependency(UserRepository.class);

//        System.out.println("Hello world!");
        MyDependencyInjector myDependencyInjector=new MyDependencyInjector();
        UserService userService= new UserService();
        myDependencyInjector.injectDependencies(userService);

        System.out.println(userService.averageUserSession());


    }
}