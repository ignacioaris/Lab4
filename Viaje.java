public class Viaje{

    private String destino;
    private double duracion;
    private double distancia;

    public Viaje(String destino, double duracion, double distancia){
        this.destino = destino;
        this.duracion = duracion;
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "destino='" + destino  +"\nduracion= " + duracion + " minutos" + "\ndistancia= " + distancia +"km";
    }
}