package dependency_injector;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class MyDependencyInjector implements DependencyInjector{
    @Override
    public void injectDependency(Object target) {
        if(target == null) return;

        Class<?> clazz = target.getClass();
        for(Field field: clazz.getDeclaredFields()){
            if(!field.isAnnotationPresent(AutoWired.class)) continue;

            field.setAccessible(true);
            try {
                field.set(target, Container.getDependency(field.getType().getName()));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public Set<Class> findAllClassesUsingReflectionsLibrary(String packageName) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        return new HashSet<>(reflections.getSubTypesOf(Object.class));
    }
    @Override
    public void getDependencies() {
        Set<Class> classes = findAllClassesUsingReflectionsLibrary("test");

        for(Class clazz: classes){
            if(!clazz.isAnnotationPresent(Component.class)) continue;

            Container.registerDependency(clazz);
//            System.out.println(clazz.get);
        }
    }
}
