package ej2;

import java.util.List;
import java.util.Scanner;

import static ej2.MetodosStreams.*;

public class Main {
    public static void main(String[] args) {
        //1. Leer el fichero y convertir cada línea en objetos Cancion.
        List<Cancion> canciones = leerCancionesDeArchivo();


        if(!canciones.isEmpty()){
            //2. Filtrar canciones cuyo tiempo total escuchado (duración × reproducciones) supere 10 minutos (600 s).
            List<Cancion> masDeDiezMin = masDeDiezMinutos(canciones);
            System.out.println("****Canciones que duran más de 10 miuntos****");
            System.out.println(masDeDiezMin);

            //3. Calcular la duración media de todas las canciones.
            double duracionMedia = duracionMedia(canciones);

            System.out.println("***Duración media***");
            System.out.println(duracionMedia);

            //4. Encontrar la más reproducida y la menos reproducida.
            Cancion masReproducida = masReproducida(canciones);

            System.out.println("***Más escuchada***");
            System.out.println(masReproducida);

            Cancion menosReproducida = menosReproducida(canciones);

            System.out.println("***Menos escuchada***");
            System.out.println(menosReproducida);

            //5. Ordenar por reproducciones (desc) y generar un ranking Top 3 como una cadena con Collectors.joining("\n").
            String ranking = ranking(canciones);

            System.out.println("***Ranking***");
            System.out.println(ranking);

            //6. Guardar el ranking y estadísticas en ranking.txt.
            exportarCancionesYEstadisticas(masDeDiezMin, duracionMedia, masReproducida,
                    menosReproducida, ranking);

            //7. (Opt.) Añadir una canción nueva desde consola y re-generar el ranking.
            Scanner teclado = new Scanner(System.in);
            System.out.println("Añade una nueva canción siguiendo los pasos");
            System.out.println("Escribe el título:");
            String nombre = teclado.nextLine();
            System.out.println("Escribe el artista:");
            String artista = teclado.nextLine();
            System.out.println("Escribe la duración en segundos:");
            int duracion = teclado.nextInt();
            System.out.println("Escribe el número de reproducciones:");
            long reproducciones = teclado.nextLong();
            teclado.close();

            Cancion nuevaCancion = new Cancion(nombre, artista, duracion, reproducciones);
            System.out.println(nuevaCancion);
            canciones.add(nuevaCancion);

            recalcularYExportar(canciones);
        }
    }
}
