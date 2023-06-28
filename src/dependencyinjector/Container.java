package dependencyinjector;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import annotation.MyAutowired;

public class Container {
    private static Container instance;

    public Map<Class<?>, Object> instances = new HashMap<>();

    private Container() {
    }

    public static synchronized Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }

        return instance;
    }

    public void registerDependencies(Class<?> clazz) throws Exception {
        Constructor<?> constructor = clazz.getConstructor();
        constructor.setAccessible(true);
        instances.put(clazz, constructor.newInstance());
    }
}
