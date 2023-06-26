import java.util.HashMap;
import java.util.Map;

public class Container {

    private Map<Class<?>, Object> dependencies;

    public Container() {
        dependencies = new HashMap<>();
    }

    public Object getDependencyInstance(Class<?> clazz) {
        // we can also implement this with lazy object creation
        // on register we can just put null, and here if object instance null, then create it, on getting.
        return dependencies.get(clazz);
    }

    void registerDependency(Class<?> clazz) {
        try {
            Object dependency = clazz.getDeclaredConstructor().newInstance();
            dependencies.put(clazz, dependency);
        } catch (Exception e) {
            System.out.println("Error occured while registering dependency and inserting into map: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
