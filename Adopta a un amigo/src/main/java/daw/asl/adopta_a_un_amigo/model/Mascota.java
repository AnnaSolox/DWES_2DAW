package daw.asl.adopta_a_un_amigo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mascota {
    private Long id;

    private String imagen = "images/default_image.jpg";

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La especie es obligatoria. Elige una opción")
    private String especie;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "Edad mínima: 0 años")
    @Max(value = 20, message = "Edad máxima: 20 años")
    private int edad;
}
