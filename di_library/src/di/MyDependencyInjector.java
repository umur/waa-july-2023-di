package di;

import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;
import static org.reflections.scanners.Scanners.TypesAnnotated;


public class MyDependencyInjector implements DependencyInjector {

    private Container diContainer;
    private Reflections reflections;


    public MyDependencyInjector() {
        diContainer = new Container();
        reflections = new Reflections("app");
    }

    @Override
    public void injectDependencies() {
        setupDI();
    }


    public void setupDI() {
        Set<Class<?>> dependenciesComponent = getAllDependenciesComponent();


        for (Class<?> component : dependenciesComponent) {
            diContainer.registerDependency(component);
        }
    }

    public Set<Class<?>> getAllDependenciesComponent() {
        return reflections.get(SubTypes.of(TypesAnnotated.with(Component.class)).asClass());
    }

    public void getDependableClassForDI(Object classObject) throws IllegalAccessException {

        for (Field field : classObject.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Dependency.class)) {
                field.setAccessible(true);
                field.set(classObject, diContainer.fetchDependency(field.getType()));
            }
        }
    }
}
