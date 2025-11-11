package daw.asl.adopta_a_un_amigo.controller;

import daw.asl.adopta_a_un_amigo.model.Mascota;
import daw.asl.adopta_a_un_amigo.service.MascotaService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MascotaViewController {

    private final MascotaService mascotaService;
    public MascotaViewController(MascotaService mascotaService){ this.mascotaService = mascotaService; }

    @GetMapping("/mascotas")
    public String listado(Model model) {
        List<Mascota> mascotas = mascotaService.listar();
        model.addAttribute("mascotas", mascotas);
        return "lista";
    }

    @GetMapping("/mascotas/{id}")
    public String detalle (@PathVariable Long id,  Model model){
        Mascota mascota = mascotaService.buscarPorId(id);
        if(mascota == null){
            return "redirect:/mascotas/nueva";
        }
        model.addAttribute("mascota", mascota);
        return "detalle";
    }
}
