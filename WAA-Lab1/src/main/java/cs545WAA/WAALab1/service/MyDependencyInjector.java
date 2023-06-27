package cs545WAA.WAALab1.service;

import cs545WAA.WAALab1.model.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class MyDependencyInjector implements DependencyInjector{

    private Container container;


    @Override
    public void createdependencyInjector(Object object){
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Autowired.class)) {
                Class<?> type = field.getType();
                Object dependency = container.getDependency(type);
                field.setAccessible(true);
                try {
                    field.set(object, dependency);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
