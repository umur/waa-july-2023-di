package cs545WAA.WAALab1.model;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Configuration;

 import java.lang.reflect.Field;
 import java.util.HashMap;
 import java.util.Map;


public class Container {
    private Map<Class<?>, Object> dependencies;

    public Container() {
        dependencies = new HashMap<>();
    }

    public Container(Map<Class<?>, Object> dependencies) {
        this.dependencies = dependencies;
    }



    public void registerDependencies(Class<?> clazz) {
        try {
            Object object = clazz.newInstance();
            dependencies.put(clazz, object);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Object getDependency(Class<?> type) {
        return dependencies.get(type);
    }
}
