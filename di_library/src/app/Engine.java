package app;

import di.Component;

@Component
public class Engine implements CarComponent {

    @Override
    public void start() {
        System.out.println("Engine is running");
    }
}
