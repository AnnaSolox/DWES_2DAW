package ej2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MetodosStreams {
    //1. Leer el fichero y convertir cada línea en objetos Cancion.
    public static List<Cancion> leerCancionesDeArchivo(){
        try(Stream<String> lineas = Files.lines(Paths.get("src/ej2/canciones.txt"))) {
            return lineas
                    .map( linea ->{
                                String[] partes = linea.split("(?<!\\s):(?!\\s)", 4);
                                return new Cancion(partes[0].trim(), partes[1].trim(),
                                        Integer.parseInt(partes[2].trim()), Long.parseLong(partes[3].trim()));
                            }
                    ).collect(Collectors.toList());
        } catch (Exception e){
            System.out.println("Error procesando el archivo " + e.getMessage());
        }
        return new ArrayList<>();
    }

    //2. Filtrar canciones cuyo tiempo total escuchado (duración × reproducciones) supere 10 minutos (600 s).
    public static List<Cancion> masDeDiezMinutos(List<Cancion> canciones){
        return canciones.stream()
                .filter(c -> (c.getDuracionSeg()* c.getReproducciones()) > 600 )
                .toList();
    }

    //3. Calcular la duración media de todas las canciones.
    public static double duracionMedia(List<Cancion> canciones){
        return (double) Math.round(canciones.stream()
                .mapToDouble(Cancion::getDuracionSeg)
                .average()
                .orElse(0.0) * 100) /100;
    }

    //4.1. Encontrar la más reproducida.
    public static Cancion masReproducida(List<Cancion> canciones){
        return canciones.stream()
                .max(Comparator.comparingLong( Cancion::getReproducciones))
                .orElse(null);
    }

    //4.2. Encontrar la menos reproducida.
    public static Cancion menosReproducida(List<Cancion> canciones){
        return canciones.stream()
                .min(Comparator.comparingLong(Cancion::getReproducciones))
                .orElse(null);
    }

    //5. Ordenar por reproducciones (desc) y generar un ranking Top 3 como una cadena con Collectors.joining("\n").
    public static String ranking(List<Cancion> canciones){
        return canciones.stream()
                .sorted(Comparator.comparingLong(Cancion::getReproducciones).reversed())
                .limit(3)
                .map(Cancion::formatoRanking)
                .collect(Collectors.joining("\n"));
    }

    //6. Guardar el ranking y estadísticas en ranking.txt.
    public static void exportarCancionesYEstadisticas(List<Cancion> masDeDiezMin, double duracionMedia,
                                                      Cancion masReproducida, Cancion menosReproducida, String ranking){
        String cancionesMasDeDiezMin = masDeDiezMin.stream()
                .map(Cancion::formatoRanking)
                .collect(Collectors.joining("\n"));
        List<String> estadisticas = List.of("****Duración media de todas las canciones****", duracionMedia + " " +
                        "segundos",
                "****Canciones cuyo tiempo de escucha total es mayor a 10 minutos*****",
                cancionesMasDeDiezMin,
                "****Canción más reproducida****",masReproducida.formatoRanking(),
                "****Canción menos reproducida****",
                menosReproducida.formatoRanking(),
                "****TOP 3 escuchadas****", ranking);
        try{
            Files.write(Paths.get("src/ej2/ranking.txt"),
                    estadisticas.stream().toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //7. Recalcular todas las estadisticas y exportarlas al ranking
    public static void recalcularYExportar(List<Cancion> canciones){
        List<Cancion> masDeDiezMin = masDeDiezMinutos(canciones);
        double duracionMedia = duracionMedia(canciones);
        Cancion masReproducida = masReproducida(canciones);
        Cancion menosReproducida = menosReproducida(canciones);
        String ranking = ranking(canciones);

        exportarCancionesYEstadisticas(masDeDiezMin, duracionMedia, masReproducida, menosReproducida, ranking);
    }
}
