package kdv.spring.kdvpetclinic.controllers;

import kdv.spring.kdvpetclinic.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller    // add to avoid:  Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'constructorInjectedController' available
public class ConstructorInjectedController {

    // no need for  @Autowired  in cae of constructor Injection
    private final GreetingService greetingService;

    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return "Constructor..., " + greetingService.sayGreeting();
    }
}
