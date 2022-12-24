package kdv.spring.kdvpetclinic.services;

import org.springframework.stereotype.Service;

@Service  // add to avoid  Field greetingService in kdv.spring.kdvpetclinic.controllers.PropertyInjectedController required a bean of type 'kdv.spring.kdvpetclinic.services.GreetingService' that could not be found.
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World from Greeting Service";
    }
}
