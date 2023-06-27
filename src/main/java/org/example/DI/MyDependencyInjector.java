package org.example.DI;

import java.lang.reflect.Field;

public class MyDependencyInjector implements DependencyInjector {
    private Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }

    @Override
    public void injectDependencies(Object target) {
        Class<?> clazz = target.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> dependencyClass = field.getType();
                Object dependency = container.resolve(dependencyClass);
                field.setAccessible(true);

                try {
                    field.set(target, dependency);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
