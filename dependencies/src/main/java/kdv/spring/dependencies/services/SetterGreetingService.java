package kdv.spring.dependencies.services;

public class SetterGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World from Setter Greeting Service";
    }
}
