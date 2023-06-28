package dependencyInjection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Container {
    private Map<Class<?>, Object> dependencies;
    public Container(){
        dependencies=new HashMap<>();

    }
    public void registerDependency(Class<?> classA) {
        try {
            Object instance = classA.getDeclaredConstructor().newInstance();
            dependencies.put(classA, instance);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }
    public <T> T getDependency(Class<T> classB) {
        Object dependency = dependencies.get(classB);
        if (dependency == null) {
            throw new RuntimeException("Dependency not registered: " + classB.getSimpleName());
        }
        return classB.cast(dependency);
    }

}
