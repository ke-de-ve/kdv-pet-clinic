package kdv.spring.di.services;

public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World from PRIMARY bean";
    }
}
