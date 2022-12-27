package kdvpetclinic.controllers;

import kdv.spring.di.controllers.PropertyInjectedController;
import kdv.spring.di.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {

    PropertyInjectedController propertyInjectedController;

    @BeforeEach
    void setUp() {
        propertyInjectedController = new PropertyInjectedController();
        propertyInjectedController.greetingService = new ConstructorGreetingService();
    }

    @Test
    void getGreeting() {
        System.out.printf("property ..., %s \n", propertyInjectedController.getGreeting());
    }
}