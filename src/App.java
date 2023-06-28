import dependencyinjector.Container;
import dependencyinjector.MyDependencyInjector;
import service.ItemRepository;
import service.ProductRepository;
import service.UserRepository;
import service.UserService;

public class App {
    public static void main(String[] args) throws Exception {
        UserService service = new UserService();
        ProductRepository productRepository = new ProductRepository();

        Container container = Container.getInstance();

        container.registerDependencies(UserRepository.class);
        container.registerDependencies(ItemRepository.class);
        container.registerDependencies(ProductRepository.class);

        MyDependencyInjector injector = new MyDependencyInjector();
        injector.createInstances();

        injector.injectDependencies(service);
        injector.injectDependencies(productRepository);

        System.out.println(service);
        System.out.println(productRepository);
    }
}
