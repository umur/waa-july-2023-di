package dependencyInjection;

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
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = container.getDependency(fieldType);

                try {
                    field.setAccessible(true);
                    field.set(target, dependency);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
