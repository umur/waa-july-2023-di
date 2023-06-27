package com.example.lab1.model;

import com.example.lab1.controller.DependencyInjector;
import com.example.lab1.controller.InjectDependency;

import java.lang.reflect.Field;

public class MyDependencyInjector implements DependencyInjector {
    private Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }

    @Override
    public void injectDependencies(Object target) {
        Class<?> targetClass = target.getClass();
        Field[] fields = targetClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectDependency.class)) {
                try {
                    field.setAccessible(true);
                    Class<?> fieldType = field.getType();
                    Object dependency = container.getDependency(fieldType);
                    field.set(target, dependency);
                } catch (IllegalAccessException e) {
                    // Handle any exceptions that occur during injection
                    e.printStackTrace();
                }
            }
        }
    }
}
