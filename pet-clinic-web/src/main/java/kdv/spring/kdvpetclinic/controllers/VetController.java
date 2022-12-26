package kdv.spring.kdvpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String  listVets() {
        // tell Thymeleafe to search for index template
        return "vets/index";
    }
}
