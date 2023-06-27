package cs545.waa-july-2023-di;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private Map<Class<?>, Object> dependencies;

    public Container() {
        this.dependencies = new HashMap<>();
    }

    public void registerDependency(Class<?> clazz) {
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            dependencies.put(clazz, instance);
        } catch (Exception e) {
            throw new RuntimeException("Error registering dependency: " + clazz.getName(), e);
        }
    }

    public Object getDependency(Class<?> clazz) {
        return dependencies.get(clazz);
    }
}
