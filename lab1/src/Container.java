import java.util.HashMap;
import java.util.Map;

public class Container {
    private final Map<Class<?>, Object> dependencyMap;

    public Container() {
        dependencyMap = new HashMap<>();
    }

    public void registerDependency(Class<?> clazz, Object dependency) {
        dependencyMap.put(clazz, dependency);
    }

    public Object getDependency(Class<?> clazz) {
        return dependencyMap.get(clazz);
    }
}
