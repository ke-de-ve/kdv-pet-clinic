package kdv.spring.dependencies.services;

//comment it out to demo configuration approach with  GreetingServiceConfig  class
//@Service
//@Primary
public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World from PRIMARY bean";
    }
}
