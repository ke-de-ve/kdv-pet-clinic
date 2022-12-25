package kdv.spring.kdvpetclinic.services;

import org.springframework.stereotype.Service;

@Service
public class PropertyGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World from Property Greeting Service";
    }
}
