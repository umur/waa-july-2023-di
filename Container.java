import java.util.HashMap;
import java.util.Map;

public class Container {
    private Map<Class<?>, Object> map;

    public Container() {
        this.map = new HashMap<>();
    }

    public void registerDependency(Class<?> class1, Object dependency){
        map.put(class1, dependency);
    }

    public Object getDependency(Class<?> class1){
        return map.get(class1);
    }
}
