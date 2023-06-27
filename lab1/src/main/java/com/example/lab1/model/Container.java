package com.example.lab1.model;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private Map<Class<?>, Object> dependencies;

    public Container() {
        dependencies = new HashMap<>();
    }

    public void registerDependency(Class<?> clazz) {
        try {
            Object dependencyInstance = clazz.getDeclaredConstructor().newInstance();
            dependencies.put(clazz, dependencyInstance);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public Object getDependency(Class<?> clazz) {
        return dependencies.get(clazz);
    }


}
