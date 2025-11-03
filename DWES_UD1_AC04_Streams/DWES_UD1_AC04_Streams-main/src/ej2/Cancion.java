package ej2;

public class Cancion {
    private final String titulo;
    private final String artista;
    private final int duracionSeg;       // duración en segundos
    private final long reproducciones;   // número de reproducciones

    public Cancion(String titulo, String artista, int duracionSeg, long reproducciones) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionSeg = duracionSeg;
        this.reproducciones = reproducciones;
    }

    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public int getDuracionSeg() { return duracionSeg; }
    public long getReproducciones() { return reproducciones; }

    /** Formato para guardar en fichero */
    public String aFichero() {
        return String.format("%s:%s:%d:%d", titulo, artista, duracionSeg, reproducciones);
    }

    /** Formato para ranking */
    public String formatoRanking() {
        return String.format("%s (%s) - %,d reproducciones", titulo, artista, reproducciones);
    }

    @Override
    public String toString() {
        return String.format("%s (%s) [%ds, %,d plays]", titulo, artista, duracionSeg, reproducciones);
    }
}
