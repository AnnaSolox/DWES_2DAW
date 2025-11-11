package daw.asl.adopta_a_un_amigo.controller;

import daw.asl.adopta_a_un_amigo.model.Mascota;
import daw.asl.adopta_a_un_amigo.service.MascotaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MascotaFormController {

    private final MascotaService mascotaService;

    public MascotaFormController(MascotaService mascotaService) {this.mascotaService = mascotaService;}

    //Pintar el formulario vacío
    @GetMapping("/mascotas/nueva")
    public String formulario(Model model){
        model.addAttribute("mascota", new Mascota());
        return "form";
    }

    //POST: recibir y validar. Aplicamos PRG
    @PostMapping("/mascotas")
    public String procesar(@Valid @ModelAttribute("mascota") Mascota mascota, BindingResult br,
                           RedirectAttributes ra){

        if(br.hasErrors()) return "form";

        Long id = mascotaService.guardar(mascota);

        ra.addAttribute("id", id);
        return "redirect:/mascotas/{id}";
    }
}
