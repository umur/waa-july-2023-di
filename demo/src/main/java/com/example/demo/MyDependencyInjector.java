package com.example.demo;

import com.example.demo.Container;
import com.example.demo.DependencyInjector;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

public class MyDependencyInjector implements DependencyInjector {

    private final Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }

    @Override
    public void injectDependencies(Object target){
        Class<?> targetClass = target.getClass();
        Field[] fields = targetClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Autowired.class)) {
                try {
                    field.setAccessible(true);
                    Object dependency = container.getBean(field.getType());
                    field.set(target, dependency);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
