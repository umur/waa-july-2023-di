package test;

import dependency_injector.Component;

@Component
public class SecondDependency {
    public SecondDependency(){
        System.out.println("Dep Created");
    }

    public void print(){
        System.out.println("Hello from Dep");
    }
}
