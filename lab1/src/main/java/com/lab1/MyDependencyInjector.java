package com.lab1;

import java.lang.reflect.Field;

// Implement the "injectDependencies" method in the "MyDependencyInjector" class to perform the actual dependency injection.
class MyDependencyInjector implements DependencyInjector {
    private Container container;
//Retrieve the corresponding dependency from the "Container" class and set it in the target object's field.
    public MyDependencyInjector(Container container) {
        this.container = container;
    }
//Use reflection to scan the target object's fields and identify the ones that are annotated with your custom injection annotation.
    @Override
    public void injectDependencies(Object target) {
        Class<?> targetClass = target.getClass();
        Field[] fields = targetClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(MyInject.class)) {
                Class<?> dependencyClass = field.getType();
                Object dependency = container.resolveDependency(dependencyClass);
//Handle any exceptions that may occur during the injection process.
                if (dependency != null) {
                    try {
                        field.setAccessible(true);
                        field.set(target, dependency);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}