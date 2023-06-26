package dependency_injector;

public interface DependencyInjector {
    void injectDependency(Object target);
    void getDependencies();
}
