package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gs on 2019-06-26
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(){

        // thymeleaf will look for a template called index.html
        return "index";
    }

    @RequestMapping("/oups")
    public String oupsHandler() {

        return "notimplemented";
    }
}
