package cs545;

import java.util.HashMap;

public class Container {
    //stores string and object as key-value pair
    private static HashMap<Class<?>, Object> dependencies;

    public Container() {
                dependencies = new HashMap <> ();
    }
    public void registerDependency(Class<?> C) {
        try {
            Object instance = C.getDeclaredConstructor().newInstance();
            dependencies.put(C, instance);
        } catch (Exception e) {
// Handle exception
            e.printStackTrace();
        }
    }

//    //adds className and object as key-value pair
//    public void registerDependency(String className, Object obj) {
//        dependencies.put(className, obj);
//    }
    //returns an Object value associated with the input key

    public Object resolveDependency(String className) {
        return dependencies.get(className);
    }
    public static <T> T getDependency(Class<T> clas ) {

        return clas.cast(dependencies);
    }
}

