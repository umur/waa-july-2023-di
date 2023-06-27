package com.miu.lab1;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private Map<Class<?>, Object> dependencies;

    public Container() {
        dependencies = new HashMap<>();
    }

    public void registerDependency(Class<?> clazz) {
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            dependencies.put(clazz, instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getDependency(Class<?> clazz) {
        return dependencies.get(clazz);
    }
}
