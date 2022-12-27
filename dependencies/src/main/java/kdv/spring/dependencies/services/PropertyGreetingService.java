package kdv.spring.dependencies.services;

public class PropertyGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World from Property Greeting Service";
    }
}
