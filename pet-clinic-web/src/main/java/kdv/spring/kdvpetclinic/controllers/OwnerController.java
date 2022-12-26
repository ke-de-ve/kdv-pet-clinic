package kdv.spring.kdvpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String  listOwners() {
        // tell Thymeleafe to search for index template
        return "owners/index";
    }
}