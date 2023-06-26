import main.Container;
import main.MyDependecyInjector;

public class Main {
    public static void main(String[] args) {

        Container.registerDependency(UserRepository2.class);
        Container.registerDependency(UserRepository.class);

        MyDependecyInjector injector = new MyDependecyInjector();

        UserService service = new UserService();
        injector.injectDependecies(service);

        System.out.println(service.repository != null);
        System.out.println(service.repository.repository2 != null);


    }
}