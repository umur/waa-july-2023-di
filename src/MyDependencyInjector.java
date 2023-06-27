import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class MyDependencyInjector implements DependencyInjector{
    public MyDependencyInjector(){

    }

    public void injectDependencies(Object target) throws IllegalAccessException {

        for(Field f : target.getClass().getDeclaredFields()){
            System.out.println(f.getName());
            if(f.isAnnotationPresent(MyAutowired.class)){
//                f.set(target,new UserRepository());
                f.set(target,Container.getRegisteredDependency(f.getType()));

            }

//
        }

    }

}
