package kdv.spring.kdvpetclinic.services;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World from Setter Greeting Service";
    }
}
