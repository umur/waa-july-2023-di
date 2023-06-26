package main;

import java.lang.reflect.Field;
import java.util.Arrays;

public class MyDependecyInjector implements DependecyInjector{
    @Override
    public void injectDependecies(Object target) {

        Class<?> clazz = target.getClass();

        for(Field field: clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Autowired.class)) {
                try {
                    field.set(target, Container.getObject(field.getType().getName()));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            if (Arrays.stream(field.getType().getClass().getDeclaredFields())
                    .anyMatch((Field f) -> f.isAnnotationPresent(Autowired.class)))
                injectDependecies(field);
        }
    }
}
