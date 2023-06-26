import java.lang.reflect.Field;

public class MyDependencyInjector implements DependencyInjector {
    private final Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }

    @Override
    public void injectDependencies(Object target) {
        Class<?> targetClass = target.getClass();
        Field[] fields = targetClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(MyCustomInjector.class)) {
                Object dependency = container.getDependency(field.getType());
                if (dependency == null) {
                    throw new RuntimeException("Dependency not found for field: " + field.getName());
                }
                field.setAccessible(true);
                try {
                    field.set(target, dependency);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to inject dependency into field: " + field.getName(), e);
                }
            }
        }
    }
}
