package ej1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));

        //1. Obtener un sublistado con las películas estrenadas en el siglo XXI (a partir del año 2000, inclusive)
        List<Pelicula> sigloXxi = peliculas.stream()
                .filter(p -> p.getEstreno() >= 2000)
                .toList();

        System.out.println(sigloXxi);

        //2. Mostrar por pantalla, separados por comas, los títulos de las películas de Steven Spielberg
        String titulosSpielberg = peliculas.stream()
                .filter(p -> p.getDirector().equals("Steven Spielberg"))
                .map(Pelicula::getTitulo)
                .collect(Collectors.joining(", "));

        System.out.println(titulosSpielberg);

        //3. Obtener un sublistado con los nombres de las películas, ordenados alfabéticamente
        List<String> titulosOrdenadosAlfabeticamente = peliculas.stream()
                .map(Pelicula::getTitulo)
                .sorted()
                .toList();

        System.out.println(titulosOrdenadosAlfabeticamente);

        //4. Mostrar por pantalla el año de estreno más reciente
        System.out.println(
                peliculas.stream()
                        .map(Pelicula::getEstreno)
                        .max(Integer::compareTo)
                        .orElse(0)
        );


    }
}
