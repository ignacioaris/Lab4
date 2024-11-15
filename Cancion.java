public class Cancion{
    private String nombre;
    private String artista;
    private double duracion;

    public Cancion(String nombre, String artista, double duracion){
        this.nombre = nombre;
        this.artista = artista;
        this.duracion = duracion;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + "\nArtista: " + artista + "\nDuración: " + duracion + " minutos\n";
    }

    public double getDuracion(){
        return duracion;
    }
    public String getNombre(){
        return nombre;
    }
}