package kdv.spring.dependencies.controllers;

import kdv.spring.dependencies.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller  // add to avoid error:   org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'propertyInjectedController' available
public class PropertyInjectedController {

    @Autowired
    @Qualifier(value = "propertyGreetingService")
    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
