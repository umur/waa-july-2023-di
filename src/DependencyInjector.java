public interface DependencyInjector {
    void injectDependencies(Object target) throws IllegalAccessException;
}
