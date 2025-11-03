package daw.asl.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @GetMapping("/helloworld")
    public String greeting(@RequestParam(required = false) String username, Model model) {
        model.addAttribute("message", "Hola " + username);
        return "greeting";
    }
}
