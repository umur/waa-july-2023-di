package org.example;

import org.example.DI.Inject;

public class AnotherService {
    @Inject
    private AnotherDependency anotherDependency;
    public void performOperation() {
       anotherDependency.doSomeThing();

    }
}
