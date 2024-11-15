import java.util.ArrayList;
public class ListaReproduccion{
    private String nombre;
    private double duracion;
    private ArrayList<Cancion> canciones;

    public ListaReproduccion(String nombre){
        this.nombre = nombre;
        this.duracion = 0;
        this.canciones = new ArrayList<>();
    }
    public void agregarCancion(Cancion cancion){
        this.canciones.add(cancion);
    }
    public void eliminarCancion(Cancion cancion){
        this.canciones.remove(cancion);
    }
    public ArrayList<Cancion> getCanciones(){
        return this.canciones;
    }
    public String mostrarCanciones(){
        for(Cancion cancion : canciones){
            return "Cancion" + cancion;
        }
        return null;
    }
    public double getDuracion(){
        int duracionTotal = 0;
        for(Cancion cancion : canciones){
            duracionTotal += cancion.getDuracion();
        }
        return duracionTotal;
    }
    public String getNombre(){
        return this.nombre;
    }

    @Override
    public String toString(){
        return "Lista de reproduccion: " + this.nombre + "\nDuracion: " + this.getDuracion() + "\nCanciones: " + this.mostrarCanciones() + "\n";
    }
}