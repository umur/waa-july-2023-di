import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Container {

    static HashMap<String,Object> items=new HashMap<>();


    public static void  registerDependency(Class<?> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = clazz.getConstructors()[0];
        Object instance = constructor.newInstance();

        items.put(clazz.getName(), instance);
    }

    public static Object getRegisteredDependency(Class<?> c ){

        return Optional.ofNullable(items.get(c.getSimpleName())).orElseThrow(RuntimeException::new);

    }
}
