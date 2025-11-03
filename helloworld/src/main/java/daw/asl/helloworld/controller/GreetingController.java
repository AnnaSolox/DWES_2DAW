package daw.asl.helloworld.controller;

import daw.asl.helloworld.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    // Cuando accedamos a esta URL, accederemos a este controlador.
    @GetMapping("/greeting")
    public String userGreeting(@RequestParam(required = false) String name1, String name2, Model model) { // Nombre
        // del controlador
        String message = "¡Bienvenido!";
        User user1;
        User user2;
        if (name1 == null && name2 == null) {
            model.addAttribute("message", message);
            return "greeting";
        }
        if (name1 != null && name2 == null) {
            user1 = new User(name1, name1.toLowerCase()+"@example.com");
            model.addAttribute("message", message);
            model.addAttribute("userObject", user1);
            return "user-greeting";
        } else if (name1 == null ) {
            user2 = new User(name2, name2.toLowerCase()+"@example.com");
            model.addAttribute("message", message);
            model.addAttribute("userObject", user2);
            return "user-greeting";
        } else {
            message = "¡Bienvenidos!";
            model.addAttribute("message", message);
            user1 = new User(name1, name1.toLowerCase()+"@example.com");
            user2 = new User(name2, name2.toLowerCase()+"@example.com");
            model.addAttribute("userObjectOne", user1);
            model.addAttribute("userObjectTwo", user2);
            return "two-users-greeting";
        }
    }
}
