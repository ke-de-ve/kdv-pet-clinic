package kdv.spring.kdvpetclinic.controllers;

import kdv.spring.kdvpetclinic.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller  // add to avoid error:   org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'propertyInjectedController' available
public class PropertyInjectedController {

    @Autowired // add to avoid  Caused by: java.lang.NullPointerException   at kdv.spring.kdvpetclinic.controllers.PropertyInjectedController.getGreeting(PropertyInjectedController.java:12)
    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
