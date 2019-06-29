package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gs on 2019-06-26
 */
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index","/vets/index.html","/vets.html"})
    public String listVets(Model model) {

        // SPECIAL NOTE: "owners" is mapped to the thymeleaf ${vets}
        // under resources/templates/vets/index.html
        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
