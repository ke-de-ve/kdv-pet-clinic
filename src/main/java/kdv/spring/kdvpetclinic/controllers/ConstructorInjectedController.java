package kdv.spring.kdvpetclinic.controllers;

import kdv.spring.kdvpetclinic.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {

    // no need for  @Autowired  in cae of constructor Injection
    private final GreetingService greetingService;

    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        // add @Qualifier to avoid confusion: Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return "Constructor..., " + greetingService.sayGreeting();
    }
}
