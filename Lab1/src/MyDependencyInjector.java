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
            if (field.isAnnotationPresent(MyAutoWired.class)) {
                Object dependency = null;
                try {
                    dependency = container.getDependencyInstance(field.getType());
                    if(dependency == null) {
                        throw new Exception("Type " + field.getType().getName() +
                                " is not registered in the Container");
                    }
                    field.setAccessible(true);
                    field.set(target, dependency);

                    // check if dependency object has dependency too
                    injectDependencies(dependency);
                } catch (Exception e) {
                    System.out.println("Exception occured while injecting dependency: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}
