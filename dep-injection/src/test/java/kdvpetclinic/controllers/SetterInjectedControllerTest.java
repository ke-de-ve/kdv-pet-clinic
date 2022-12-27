package kdvpetclinic.controllers;

import kdv.spring.di.controllers.SetterInjectedController;
import kdv.spring.di.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {

    SetterInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new SetterInjectedController();
        controller.setGreetingService(new ConstructorGreetingService());
    }

    @Test
    void getGreeting() {
        System.out.printf("Setter ..., %s \n", controller.getGreeting());
    }
}