package app;

import di.Component;

@Component
public class Transmission implements CarComponent {

    @Override
    public void start() {
        System.out.println("Transmission is ready to shift");
    }
}
