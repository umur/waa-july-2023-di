package com.waa_lab1;

import java.lang.reflect.Field;

class MyDependencyInjector implements DependencyInjector {
    private Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }

    public void injectDependencies(Object target) {
        Class<?> targetClass = target.getClass();
        Field[] fields = targetClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = container.resolveDependency(fieldType);
                field.setAccessible(true); // Set the field accessible
                try {
                    field.set(target, dependency);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
