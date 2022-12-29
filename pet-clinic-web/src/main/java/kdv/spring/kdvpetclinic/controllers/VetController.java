package kdv.spring.kdvpetclinic.controllers;

import kdv.spring.kdvpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets.html", "/vets", "/vets/index", "/vets/index.html"})
    public String  listVets(Model model) {
        model.addAttribute("vetsAll", vetService.findAll());
        return "vets/index";
    }
}
