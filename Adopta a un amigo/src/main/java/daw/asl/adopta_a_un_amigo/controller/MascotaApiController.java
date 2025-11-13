package daw.asl.adopta_a_un_amigo.controller;

import daw.asl.adopta_a_un_amigo.model.Mascota;
import daw.asl.adopta_a_un_amigo.service.MascotaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MascotaApiController {

    private final MascotaService mascotaService;
    public MascotaApiController(MascotaService mascotaService){ this.mascotaService = mascotaService; }

    @PostMapping("mascotas/borrar")
    public String borrarMascota (Long id) {
        mascotaService.borrarMascota(id);
        return "redirect:/mascotas";
    }

    @GetMapping("mascotas/{id}/editar")
    public String editarMascota (@PathVariable Long id, Model model){
        Mascota mascota = mascotaService.buscarPorId(id);
        model.addAttribute("mascota", mascota);
        return "form";
    }
}
