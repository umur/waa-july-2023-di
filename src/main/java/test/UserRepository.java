package test;

import dependency_injector.AutoWired;
import dependency_injector.Component;

@Component
public class UserRepository {

    @AutoWired
    public SecondDependency dependency;
    public UserRepository(){
        System.out.println("Hello form the Constructor");
    }
    public void print(){
        System.out.println("Hello World");
    }

    @Override
    public String toString() {
        return "Repo";
    }
}
