import dependencyInjection.Container;
import dependencyInjection.MyDependencyInjector;

public class Main {
    public static void main(String []args){
        UserService userService=new UserService();
        Container container=new Container();
        container.registerDependency(UserRepository.class);
        MyDependencyInjector myDependencyInjector=new MyDependencyInjector(container);
        myDependencyInjector.injectDependencies(userService);

        container.registerDependency(OtherDependency.class);
        AnotherClass anotherClass=new AnotherClass();
        myDependencyInjector.injectDependencies(anotherClass);


    }
}
