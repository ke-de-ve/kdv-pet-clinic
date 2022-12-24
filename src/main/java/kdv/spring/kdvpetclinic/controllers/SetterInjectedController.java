package kdv.spring.kdvpetclinic.controllers;

import kdv.spring.kdvpetclinic.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller   // add to avoid:   Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'setterInjectedController' available
public class SetterInjectedController {

    @Autowired   // add to avoid:   Caused by: java.lang.NullPointerException    at kdv.spring.kdvpetclinic.controllers.SetterInjectedController.getGreeting(SetterInjectedController.java:16)
    private GreetingService greetingService;

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
