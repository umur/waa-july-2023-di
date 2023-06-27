package cs545.waa;


import java.lang.reflect.Field;

public class MyDependencyInjector implements cs545.waa.DependencyInjector {
    private final cs545.waa.Container container;

    public MyDependencyInjector(cs545.waa.Container container) {
        this.container = container;
    }

    @Override
    public void injectDependencies(Object target) {
        Class<?> clazz = target.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(cs545.waa.Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = container.getDependency(fieldType);
//                System.out.println(">>>>>>>"+ dependency);

                if (dependency == null) {
                    throw new RuntimeException("Dependency not found for field: " + field.getName());
                }
                field.setAccessible(true);
                try {
                    field.set(target, dependency);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error injecting dependency into field: " + field.getName(), e);
                }
            }
        }
    }
}



