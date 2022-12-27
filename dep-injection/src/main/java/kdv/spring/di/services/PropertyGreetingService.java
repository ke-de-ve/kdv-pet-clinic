package kdv.spring.di.services;

public class PropertyGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World from Property Greeting Service";
    }
}
