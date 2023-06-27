package com.lab1;

// Custom annotation to mark fields for dependency injection
@interface MyInject {}

// Interface for dependency injection
public interface DependencyInjector {
    void injectDependencies(Object target);
}
