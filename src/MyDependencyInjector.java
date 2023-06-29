import java.lang.reflect.Field;

public class MyDependencyInjector implements DependencyInjector {
    private Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }

    @Override
    public void injectDependencies(Object target) {
        try {
            for (Field field : target.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    Class<?> theFieldType = field.getType();
                    Object ob = container.getObjectByType(theFieldType);
                    field.setAccessible(true);
                    field.set(target, ob);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
