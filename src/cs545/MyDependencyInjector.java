package cs545;

import java.lang.reflect.Field;

public class MyDependencyInjector implements DependencyInjector{

        public void injectDependencies(Object target) {
            // Get all fields of the target object
            Field[] fields = target.getClass().getDeclaredFields();
            for (Field field : fields) {
                // Check if the field is annotated with the custom injection annotation
                if (field.isAnnotationPresent(InjectDependency.class)) {
                    try {
                        // Get the dependency from the container class
                        Object dependency = Container.getDependency(field.getType());
                        // Set the dependency in the target object's field
                        field.setAccessible(true);
                        field.set(target, dependency);
                    } catch (Exception e) {
                        // Handle exceptions such as missing dependency or inaccessible field
                        e.printStackTrace();
                    }
                }
            }
        }



}
