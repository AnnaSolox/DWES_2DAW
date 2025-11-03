package org.annasolox.models;

public class Libro {
    private String titulo;
    private String autor;
    private String editorial;
    private String isbn;
    private int anio;

    public Libro(String titulo, String autor, String editorial, String isbn, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.isbn = isbn;
        this.anio = anio;
    }

    public String getTitulo(){return titulo;}
    public String getAutor(){return autor;}
    public String getEditorial(){return editorial;}
    public String getIsbn(){return isbn;}
    public int getAnio(){return anio;}

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Editorial: " + editorial + ", Isbn: " + isbn + ", Anio: " + anio;
    }
}
