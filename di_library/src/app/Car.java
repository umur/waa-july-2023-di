package app;

import di.Dependency;

public class Car {
    @Dependency
    private Engine engine;

    @Dependency
    private Transmission transmission;

    public void startCar(){
        engine.start();
        transmission.start();
    }

}
