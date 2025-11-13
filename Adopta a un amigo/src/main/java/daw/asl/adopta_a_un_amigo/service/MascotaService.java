package daw.asl.adopta_a_un_amigo.service;

import daw.asl.adopta_a_un_amigo.model.Mascota;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MascotaService {
    private final AtomicLong secuencia = new AtomicLong(1);
    private final List<Mascota> bd = new CopyOnWriteArrayList<>();

    public Long guardar(Mascota mascota){
        if(mascota.getId() == null){
            Long id = secuencia.getAndIncrement();
            mascota.setId(id);
            bd.add(mascota);
            return id;
        } else {
            bd.removeIf(m -> Objects.equals(m.getId(), mascota.getId()));
            bd.add(mascota);
            return mascota.getId();
        }
    }

    public Mascota buscarPorId(Long id){
        Mascota mascota = bd.stream()
                .filter( m -> Objects.equals(m.getId(), id))
                .findFirst()
                .orElse(null);
        System.out.println(mascota);
        return mascota;
    }

    public void borrarMascota (Long id){
        bd.removeIf(mascota -> Objects.equals(mascota.getId(), id));
    }

    public List<Mascota> listar(){
        return List.copyOf(bd);
    }
}
