package dependency_injector;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Container {
    private static Map<String, Object> dependencyMap = new HashMap<String, Object>();

    public static void registerDependency(Class<?> clazz){

        if(dependencyMap.containsKey(clazz.getName())) return;

//        Parameter[] parameters = clazz.

        try {
            Object obj = clazz.getConstructor().newInstance();
            dependencyMap.put(clazz.getName(), obj);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }

    public static  Object getDependency(String className){
        return dependencyMap.get(className);
    }






}
