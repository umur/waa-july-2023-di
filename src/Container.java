import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Container {
    private List<Object> dependencyObjectMap = new ArrayList<>();

    public void registerDependency(Class<?> clazz) {
        try {
            Object ob = clazz.getDeclaredConstructor().newInstance();
            dependencyObjectMap.add(ob);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public Object getObjectByType(Class<?> clazz) {
        Object ob = null;
        try {
            for (Object dependencyObject : dependencyObjectMap) {
                if (dependencyObject.getClass().getName().contentEquals(clazz.getName()))
                    ob = dependencyObject;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ob;
    }


}
