package org.annasolox;

import java.util.*;
import java.util.function.*;

class Pelicula
{
    private String titulo;
    private String director;
    private int estreno;
    
    public Pelicula(String titulo, String director, int estreno)
    {
        this.titulo = titulo;
        this.director = director;
        this.estreno = estreno;
    }
    
    public String getTitulo()
    {
        return titulo;
    }
    
    public String getDirector()
    {
        return director;
    }
    
    public int getEstreno()
    {
        return estreno;
    }
    
    @Override
    public String toString()
    {
        return titulo + " (" + director + ", " + estreno + ")";
    }
}

public class EjercicioSeccion2 
{
    static void mostrar(List<Pelicula> peliculas, Consumer<Pelicula> c)
    {
        System.out.println("***Mostrando con la función mostrar de la clase EjercicioSeccion2");
        peliculas.forEach(p -> c.accept(p));
    }
    
    public static void main(String[] args)
    {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));

        // Consumer que se enviará a la función "mostrar"
        Consumer<Pelicula> cMostrar = System.out::println;

        /*
        * Ordena el listado de películas que aparece por año de estreno, de más reciente a más antiguo, y muestra el
        * resultado. */
        Comparator<Pelicula> cEstreno = Comparator.comparingInt(Pelicula::getEstreno).reversed();
        peliculas.sort(cEstreno);
        System.out.println("***Películas ordenadas por año de estreno de más reciente a más antiguo***");
        mostrar(peliculas, cMostrar);
        /*
        * Tras la ordenación anterior, utiliza una combinación de comparadores para ordenar por director (ascendente), y cuando éste sea igual, por título de la película (ascendente). Muestra nuevamente el listado ordenado por este criterio
        */
        Comparator<Pelicula> cDirector = Comparator.comparing(Pelicula::getDirector);
        Comparator<Pelicula> cTitulo = Comparator.comparing(Pelicula::getTitulo);
        peliculas.sort(cDirector.thenComparing(cTitulo));
        System.out.println("***Películas ordenadas por director y, cuando éste coincida, por título***");
        mostrar(peliculas, cMostrar);

        /*
         * Completa la función "mostrar" de la clase EjercicioSeccion2 para que aplique el consumidor "c" a todos los elementos del listado que recibe como parámetro. Utiliza esta función para mostrar los listados de ordenaciones de los pasos anteriores
         * */
    }
}
