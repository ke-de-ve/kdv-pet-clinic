package kdv.spring.kdvpetclinic.controllers;

import kdv.spring.kdvpetclinic.services.GreetingService;

public class ConstructorInjectedController {

    private final GreetingService greetingService;

    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return "Constructor..., " + greetingService.sayGreeting();
    }
}
