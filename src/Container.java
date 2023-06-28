import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public enum Container {
    INSTANCE;
    private Map<Class<?>, Class<?>> diMap;
    private Map<Class<?>, Object> applicationScope;


    private Container() {
        diMap = new HashMap<>();
        applicationScope = new HashMap<>();
    }

    public void registerDependency(Class<?> clazz){
        if(!applicationScope.containsKey(clazz)){
            Object classInstance = null;
            try {
                classInstance = clazz.getDeclaredConstructor().newInstance();
                applicationScope.put(clazz, classInstance);
                System.out.println( clazz+" "+applicationScope.get(clazz));
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Object getObjectOfClass(Class<?> clazz){
        System.out.println( clazz+" "+applicationScope.get(clazz));
        System.out.println( applicationScope.containsKey(clazz));

        return applicationScope.get(clazz);
    }

}
