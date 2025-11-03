package ej2;

public class Main {
    public static void main(String[] args) {
        // Objeto anónimo
        Saludable consejoAlimentacion = new Saludable() {
            @Override
            public void mostrarConsejo() {
                System.out.println("Come al menos 2 o 3 porciones de frutas y 2 a 3 porciones de verduras al día");
            }
        };

        Saludable consejoEjercicio = new Saludable() {
            @Override
            public void mostrarConsejo() {
                System.out.println("Realizar solo diez minutos de actividad física al día, como caminar a paso ligero, puede tener un impacto significativo en la salud");
            }
        };

        consejoAlimentacion.mostrarConsejo();
        consejoEjercicio.mostrarConsejo();

        Vehiculo moto = new Vehiculo() {
            @Override
            void arrancar() {
                System.out.println("Arrancando moto...");
            }
        };

        moto.arrancar();

    }
}
