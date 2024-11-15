import java.util.ArrayList;

public class RadioClaseA implements IRadioClaseA {
    private boolean encendido;
    private int volumen;
    private String modoActual;
    private ListaReproduccion listaActual;
    private String frecuencia;
    private double emisoraActual;
    private double[] emisorasGuardadas;
    private ArrayList<Contacto> contactos;
    private ArrayList<ListaReproduccion> listas;
    private boolean telefonoConectado;
    private boolean altavozActivo;
    private Cancion cancionActual;
    private ArrayList<Viaje> viajes;
    private int indiceCancion;

    public RadioClaseA(){
        this.encendido = false;
        this.volumen = 0;
        this.modoActual = "Radio";
        this.listaActual = null;
        this.frecuencia = "FM";
        this.emisoraActual = 90.0;
        this.emisorasGuardadas = new double[50];
        this.contactos = new ArrayList<>();
        this.listas = new ArrayList<>();
        this.listaActual = null;
        this.telefonoConectado = false;
        this.altavozActivo = false;
        this.cancionActual = null;
    }
    public int getVolumen(){
        return this.volumen;
    }
    public boolean estaConectado(){
        return this.telefonoConectado;
    }
    public boolean estaEncendido(){
        return this.encendido;
    }
    public double[] getEmisorasGuardadas(){
        return this.emisorasGuardadas;
    }
    public String getModo(){
        return this.modoActual;
    }
    public ArrayList<ListaReproduccion> getListas(){
        return this.listas;
    }
    public String getFrecuencia(){
        return this.frecuencia;
    }
    public ListaReproduccion getListaReproduccion(){
        return this.listaActual;
    }
    public double getEmisora(){
        return this.emisoraActual;
    }
    public Cancion getCancion(){
        return this.cancionActual;
    }
    public ArrayList<Contacto> getContactos(){
        return this.contactos;
    }

    @Override
    public void encender() {
        encendido = true;
    }

    @Override
    public void apagar() {
        encendido = false;
    }

    @Override
    public void aumentarVolumen() {
        volumen += 1;
    }

    @Override
    public void disminuirVolumen() {
        if (volumen > 0) {
            volumen -= 1;
        }
    }
    
    @Override
    public void cambiarModo() {
            switch (modoActual) {
            case "Radio":
            modoActual = "Reproductor";
            break;
            case "Reproductor":
            modoActual = "Telefono";
            break;
            case "Telefono":
            modoActual = "Radio";
            break;
        }
    }

    @Override
    public void cambiarFrecuencia() {
        frecuencia = frecuencia.equals("FM") ? "AM" : "FM";
    }

    @Override
    public void cambiarEmisora() {
        emisoraActual += 0.5;
    }

    @Override
    public void guardarEmisora() {
        int i = 0;
        while (emisorasGuardadas[i] != 0 && i < 50) {
            i++;
        }
        if (i < 50) {
            emisorasGuardadas[i] = emisoraActual;
        }
    }

    @Override
    public void cargarEmisora(int indice) {
        if (indice >= 0 && indice < 50) {
            emisoraActual = emisorasGuardadas[indice];
        }
    }

    @Override
    public void seleccionarLista(ListaReproduccion lista) {
        listaActual = lista;
        indiceCancion = 0;
    }

    @Override
    public void reproducirCancion(){
        cancionActual = listaActual.getCanciones().get(indiceCancion);
    }
    @Override
    public void cambiarCancion() {
            if(listaActual != null){
                indiceCancion +=1 % listaActual.getCanciones().size();
            }
    }

    @Override
    public void mostrarInfoCancion() {
        System.out.println(cancionActual);
    }

    @Override
    public void conectarTelefono() {
        telefonoConectado = true;
    }

    @Override
    public void desconectarTelefono() {
        telefonoConectado = false;
    }

    @Override
    public void mostrarContactos() {
        for(Contacto contacto: contactos){
            System.out.println(contacto);
        }
    }

    @Override
    public void llamarContacto(Contacto contacto) {
        System.out.println("lammando a " + contacto.getNombre());
    }

    @Override
    public void finalizarLlamada() {
        System.out.println("Llamada finalizada.");
    }

    @Override
    public void cambiarAltavoz() {
        altavozActivo =! altavozActivo;
    }

    @Override
    public void planificarViaje(String destino, double duracion, double distancia) {
        Viaje viaje = new Viaje(destino, duracion, distancia);
        viajes.add(viaje);
    }
}
