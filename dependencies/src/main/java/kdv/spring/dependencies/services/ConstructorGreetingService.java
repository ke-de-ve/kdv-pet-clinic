package kdv.spring.dependencies.services;

//comment it out to demo configuration approach with  GreetingServiceConfig  class
// imitating working with 3rd party components
// @Service
public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World from Constructor Greeting Service";
    }
}
