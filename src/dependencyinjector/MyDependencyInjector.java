package dependencyinjector;

import java.lang.reflect.Field;
import java.util.Map;

import annotation.MyAutowired;

public class MyDependencyInjector implements DependencyInjector {
    private Container container = Container.getInstance();

    @Override
    public void injectDependencies(Object target) throws Exception {
        for (Field field : target.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MyAutowired.class)) {
                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                field.set(target, container.instances.get(fieldType));
            }
        }
    }

    public void createInstances() throws IllegalArgumentException, IllegalAccessException {
        for (Map.Entry<Class<?>, Object> entrySet : container.instances.entrySet()) {
            for (Field field : entrySet.getValue().getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(MyAutowired.class)) {
                    Class<?> fieldType = field.getType();

                    field.setAccessible(true);
                    for (Map.Entry<Class<?>, Object> tempEntrySet : container.instances.entrySet()) {
                        if (fieldType.isInstance(tempEntrySet.getValue())) {
                            field.set(entrySet.getValue(), tempEntrySet.getValue());
                        }
                    }
                }
            }
        }
    }
}
