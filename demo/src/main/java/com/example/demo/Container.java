package com.example.demo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Container {
    private final Map<Class<?>, Object> beanMap;

    public Container() {
        beanMap = new HashMap<>();
    }

    public void registerDependency(Class<?> clazz) {
        if (!beanMap.containsKey(clazz)) {
            try {
                Object instance = clazz.getDeclaredConstructor().newInstance();
                beanMap.put(clazz, instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public Object getBean(Class<?> clazz) {
        return beanMap.get(clazz);
    }
}