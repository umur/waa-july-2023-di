import java.lang.reflect.Field;

public class MyDependencyInjector implements DependencyInjector{
    private final Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }

    @Override
    public void injectDependencies(Object target) {
        System.out.println("Dependency Injection interface called");
        Class<?> class1 = target.getClass();
        Field[] fields = class1.getDeclaredFields();

        for (Field field : fields){
            if (field.isAnnotationPresent(Inject.class)){
                Object dependency = container.getDependency(field.getType());
                if (dependency == null) throw new RuntimeException("Dependency not found for field: "+field.getName());
                try {
                    field.setAccessible(true);
                    field.set(target, dependency);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to inject dependency into field"+field.getName(), e);
                }
            }
        }
    }
}
