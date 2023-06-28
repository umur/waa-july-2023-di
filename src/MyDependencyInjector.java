import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public enum MyDependencyInjector implements DependencyInjector{
    INSTANCE;
    private Map<Class<?>, Class<?>> diMap;
    private Map<Class<?>, Object> applicationScope;
    private MyDependencyInjector(){
        diMap = new HashMap<>();
        applicationScope = new HashMap<>();
    }

    @Override
    public void injectDependencies(Object target) throws IllegalAccessException {
        Field[] allFields = target.getClass().getDeclaredFields();
        for (Field field : allFields) {
            if(field.isAnnotationPresent(Autowired.class)) {
                field.setAccessible(true);
                field.set(target,Container.INSTANCE.getObjectOfClass(field.getType()));
            }
        }
    }
}
