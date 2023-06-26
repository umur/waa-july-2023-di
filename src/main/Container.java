package main;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Container {

    private static Map<String, Object> mappings = new HashMap<>();

    public static boolean registerDependency(Class<?> clazz){

        if(mappings.containsKey(clazz.getName()))
            return false;

        try {
            Object obj = clazz.getConstructor().newInstance();

            if (Arrays.stream(clazz.getDeclaredFields())
                    .anyMatch((Field f) -> f.isAnnotationPresent(Autowired.class)))
                new MyDependecyInjector().injectDependecies(obj);

            mappings.put(clazz.getName(), obj);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        return  true;
    }

    public static Object getObject(String name){
        if(!mappings.containsKey(name))
            throw new IllegalArgumentException();

        return mappings.get(name);
    }

}
