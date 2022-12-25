package kdv.spring.kdvpetclinic.controllers;

import kdv.spring.kdvpetclinic.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    // no need to add qualifier if we want to use primary bean
    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
