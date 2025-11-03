package ej3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Libro> listaLibros = new ArrayList<>();
        listaLibros.add(new Libro("Ready Player One", "Ernest Cline", 374));
        listaLibros.add(new Libro("El marciano (The Martian)", "Andy Weir", 384));
        listaLibros.add(new Libro("Neuromante (Neuromancer)", "William Gibson", 271));
        listaLibros.add(new Libro("Snow Crash", "Neal Stephenson", 470));
        listaLibros.add(new Libro("Dune", "Frank Herbert", 688));

        //Clase anónima
        Comparator<Libro> cPaginas = new Comparator<>() {
            @Override
            public int compare(Libro l1, Libro l2) {
                return l1.getPaginas() - l2.getPaginas();
            }
        };

        //Expresión lambda
        Comparator<Libro> cTitulo = (l1, l2) -> l1.getTitulo().compareTo(l2.getTitulo());

        //Comparator.comparing()
        Comparator<Libro> cAutor = Comparator.comparing(Libro::getAutor).reversed();

        System.out.println("\nLibros ordenados por páginas ascendente");
        listaLibros.sort(cPaginas);
        listaLibros.forEach(System.out::println);

        System.out.println("\nLibros ordenados por título alfabéticamente");
        listaLibros.sort(cTitulo);
        listaLibros.forEach(System.out::println);

        System.out.println("\nLibros ordenados por autor descendente");
        listaLibros.sort(cAutor);
        listaLibros.forEach(System.out::println);
    }
}
