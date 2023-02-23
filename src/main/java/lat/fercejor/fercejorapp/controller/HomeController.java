package lat.fercejor.fercejorapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String inicio() {
        return "inicio";
    }

    // @GetMapping("/error")
    // public String error() {
    //     return "error";
    // }
    
}
