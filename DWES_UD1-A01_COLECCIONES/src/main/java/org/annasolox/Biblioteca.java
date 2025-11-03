package org.annasolox;

import org.annasolox.models.Libro;
import org.annasolox.models.Usuario;

import java.util.*;

public class Biblioteca {
    private final Stack<Libro> historial;
    private final Queue<String> cola;
    private final Set<String> catalogo;
    private final HashMap<String, String> usuarios;
    private final TreeMap<String, Integer> descargas;

    public Biblioteca() {
        historial = new Stack<>();
        cola = new LinkedList<>();
        catalogo = new HashSet<>();
        usuarios = new HashMap<>();
        descargas = new TreeMap<>();
    }

    public void abrirLibro(Libro libro){
        historial.push(libro);
    }

    public void mostrarUltimoLibroConsultado(){
        System.out.println("Último libro consultado: " + historial.peek());
    }

    public void retrocederEnElHistorial(){
        historial.pop();
    }

    public void listarLibrosConsultados(){
        System.out.println("Historial de libros consultados: ");
        historial.forEach(System.out::println);
    }

    public void aniadirUsuarioACola(Usuario usuario){
        cola.offer(usuario.getNombre());
    }

    public void atenderUsuarioCola(){
        cola.poll();
    }

    public void mostrarCola(){
        System.out.println("Cola para leer el libro: " + cola);
    }

    public void insertarEnCatalogo(Libro libro){
        String titulo = libro.getTitulo();
        catalogo.add(titulo);
    }

    public void comprobarCatalogo(String titulo){
        if(catalogo.contains(titulo)){
            System.out.println("El libro \"" + titulo + "\" está disponible");
        } else {
            System.out.println("El libro \"" + titulo + "\" no está disponible");
        }
    }

    public void mostrarTitulosDisponibles(){
        System.out.println("Títulos disponibles en catálogo: " + catalogo);
    }

    public void registrarUsuario(Usuario usuario){
        usuarios.put(usuario.getNombre(), usuario.getContrasenia());
    }

    public void verificarInicioSesion(Usuario usuario){
        String contraseniaGuardada = usuarios.get(usuario.getNombre());
        if (contraseniaGuardada!=null && contraseniaGuardada.equals(usuario.getContrasenia())){
            System.out.println("Inicio sesión con éxito");
        } else {
            System.out.println("No se puede iniciar sesión, el usuario no existe");
        }
    }

    public void mostrarTodosLosUsuarios(){
        usuarios.keySet().forEach(System.out::println);
    }

    public void aniadirLibroADescargar(String titulo, int numeroDescargas){
        descargas.put(titulo, numeroDescargas);
    }

    public void mostrarAlfabeticamentePorTitulo(){
        System.out.println("Libros ordenados alfabeticamente por titulo: ");
        descargas.keySet().forEach(System.out::println);
    }

    public void consultarPrimerLibro(){
        System.out.println("Primer libro: " + descargas.firstEntry().getKey() + " - Descargas: " + descargas.firstEntry().getValue());
    }
    public void consultarUltimoLibro(){
        System.out.println("Último libro: " + descargas.lastEntry().getKey() + " - Descargas: " + descargas.lastEntry().getValue());
    }

    public List<Libro> getLibrosPredefinidos(){

        return new ArrayList<>(List.of(
                new Libro("1984", "George Orwell", "Secker & Warburg", "1234567890", 1949),
                new Libro("El Principito", "Antoine de Saint-Exupéry", "Reynal & Hitchcock", "2345678901", 1943),
                new Libro("Cien Años de Soledad", "Gabriel García Márquez", "Sudamericana", "3456789012", 1967),
                new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "Francisco de Robles", "4567890123", 1605),
                new Libro("Orgullo y Prejuicio", "Jane Austen", "T. Egerton", "5678901234", 1813),
                new Libro("Moby Dick", "Herman Melville", "Harper & Brothers", "6789012345", 1851),
                new Libro("Hamlet", "William Shakespeare", "N/A", "7890123456", 1603),
                new Libro("El Hobbit", "J.R.R. Tolkien", "George Allen & Unwin", "8901234567", 1937),
                new Libro("La Metamorfosis", "Franz Kafka", "Kurt Wolff Verlag", "9012345678", 1915),
                new Libro("Crimen y Castigo", "Fiódor Dostoyevski", "The Russian Messenger", "0123456789", 1866)
        ));
    }

    public List<Usuario> getUsuariosPredefinidos(){

        return new ArrayList<>(List.of(
                new Usuario("Anna", "asdasdf321654"),
                new Usuario("Enrique", "faoDIJH90y5"),
                new Usuario("Erika", "32984sdfkjQO3G"),
                new Usuario("Jordi", "234weafjbro8q237")
        ));
    }

}
