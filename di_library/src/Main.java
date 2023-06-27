import app.Car;
import di.MyDependencyInjector;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException {

        //object that needs dependency injection
        Car myCar = new Car();

        //dependency injector starter
        MyDependencyInjector myDependencyInjector = new MyDependencyInjector();

        //preparing DI graph
        myDependencyInjector.injectDependencies();

        myDependencyInjector.getDependableClassForDI(myCar);

        myCar.startCar();
    }
}