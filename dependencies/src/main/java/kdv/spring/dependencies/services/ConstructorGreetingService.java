package kdv.spring.dependencies.services;

public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World from Constructor Greeting Service";
    }
}
