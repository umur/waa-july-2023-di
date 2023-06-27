package com.lab1;

import java.util.HashMap;
import java.util.Map;

// creating class called "Container" that acts as the dependency injection container
// Dependency injection container
class Container {
    //Add a private field in the "Container" class to store a mapping of dependencies.
    private Map<Class<?>, Object> dependencies = new HashMap<>();

    //Implementing a method in the "Container" class, e.g., "registerDependency(Class<?> clazz)", to register dependencies.
    public void registerDependency(Class<?> clazz, Object instance) {
        dependencies.put(clazz, instance);
    }

    public Object resolveDependency(Class<?> clazz) {
        return dependencies.get(clazz);
    }
}
