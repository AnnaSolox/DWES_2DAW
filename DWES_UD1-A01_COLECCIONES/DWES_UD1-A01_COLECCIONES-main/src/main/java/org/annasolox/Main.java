package org.annasolox;


import org.annasolox.models.Libro;
import org.annasolox.models.Usuario;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        // Cargar libros y usuarios predefinidos
        List<Libro> libros = biblioteca.getLibrosPredefinidos();
        List<Usuario> usuarios = biblioteca.getUsuariosPredefinidos();

        //Ejercicio 1.
        //1.1
        biblioteca.abrirLibro(libros.get(3));
        biblioteca.abrirLibro(libros.get(1));
        biblioteca.abrirLibro(libros.get(2));
        biblioteca.abrirLibro(libros.get(4));
        biblioteca.abrirLibro(libros.get(5));
        biblioteca.abrirLibro(libros.get(6));
        biblioteca.abrirLibro(libros.get(7));

        //1.2
        biblioteca.mostrarUltimoLibroConsultado();
        biblioteca.listarLibrosConsultados();
        biblioteca.retrocederEnElHistorial();
        biblioteca.mostrarUltimoLibroConsultado();

        //Ejercicio 2.
        //2.1
        biblioteca.aniadirUsuarioACola(new Usuario("Anna", "asdasdf321654"));
        biblioteca.aniadirUsuarioACola(new Usuario("Enrique", "faoDIJH90y5"));
        biblioteca.aniadirUsuarioACola(new Usuario("Erika", "32984sdfkjQO3G"));
        biblioteca.aniadirUsuarioACola(new Usuario("Jordi", "234weafjbro8q237"));
        //2.2
        biblioteca.atenderUsuarioCola();
        //2.3
        biblioteca.mostrarCola();

        //Ejercicio 3.
        //3.1
        biblioteca.insertarEnCatalogo(libros.get(0));
        biblioteca.insertarEnCatalogo(libros.get(9));
        biblioteca.insertarEnCatalogo(libros.get(9));
        biblioteca.insertarEnCatalogo(libros.get(7));
        biblioteca.insertarEnCatalogo(libros.get(7));
        biblioteca.insertarEnCatalogo(libros.get(3));
        biblioteca.insertarEnCatalogo(libros.get(1));
        //3.2
        biblioteca.comprobarCatalogo("Moby Dick");
        biblioteca.comprobarCatalogo("El Principito");
        //3.3
        biblioteca.mostrarTitulosDisponibles();

        //Ejercicio 4.
        //4.1
        usuarios.forEach(biblioteca::registrarUsuario);
        biblioteca.registrarUsuario(new Usuario("Juan", "askfjbPQ3984Y"));
        //4.2
        biblioteca.verificarInicioSesion(usuarios.getFirst());
        biblioteca.verificarInicioSesion(new Usuario("Enrique", "faoathst123"));
        //4.3
        biblioteca.mostrarTodosLosUsuarios();

        //Ejercicio 5
        //5.1
        biblioteca.aniadirLibroADescargar(libros.getFirst().getTitulo(), 3);
        biblioteca.aniadirLibroADescargar(libros.getLast().getTitulo(), 2);
        biblioteca.aniadirLibroADescargar(libros.get(3).getTitulo(), 5);
        biblioteca.aniadirLibroADescargar(libros.get(4).getTitulo(), 6);
        biblioteca.aniadirLibroADescargar(libros.get(1).getTitulo(), 2);
        biblioteca.aniadirLibroADescargar(libros.get(2).getTitulo(), 4);
        biblioteca.aniadirLibroADescargar(libros.get(5).getTitulo(), 8);
        biblioteca.aniadirLibroADescargar(libros.get(6).getTitulo(), 8);
        biblioteca.aniadirLibroADescargar(libros.get(7).getTitulo(), 1);
        biblioteca.aniadirLibroADescargar(libros.get(8).getTitulo(), 2);
        biblioteca.aniadirLibroADescargar(libros.get(9).getTitulo(), 1);
        //5.2
        biblioteca.mostrarAlfabeticamentePorTitulo();
        //5.3
        biblioteca.consultarPrimerLibro();
        biblioteca.consultarUltimoLibro();
    }
}