package kdv.spring.dependencies.services;

//comment it out to demo configuration approach with  GreetingServiceConfig  class
// imitating working with 3rd party components
// @Service
public class SetterGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World from Setter Greeting Service";
    }
}
