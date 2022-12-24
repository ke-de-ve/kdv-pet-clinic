package kdv.spring.kdvpetclinic.controllers;

import kdv.spring.kdvpetclinic.services.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
