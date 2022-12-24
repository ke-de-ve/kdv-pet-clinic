package kdv.spring.kdvpetclinic.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String sayHello() {
        System.out.println("hello World !");

        return "Hi, Folks!";
    }
}
