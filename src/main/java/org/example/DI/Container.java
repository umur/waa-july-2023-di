package org.example.DI;

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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Object resolve(Class<?> clazz) {
        return dependencies.get(clazz);
    }
}
