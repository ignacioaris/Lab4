public interface IRadioClaseA {
    void encender();
    void apagar();
    void aumentarVolumen();
    void disminuirVolumen();
    void cambiarModo();

    void cambiarFrecuencia();
    void cambiarEmisora();
    void guardarEmisora();
    void cargarEmisora(int indice);

    void seleccionarLista(ListaReproduccion lista);
    void reproducirCancion(Cancion cancion);
    void cambiarCancion(Cancion cancion);
    void mostrarInfoCancion();

    void conectarTelefono();
    void desconectarTelefono();
    void mostrarContactos();
    void llamarContacto(Contacto contacto);
    void finalizarLlamada();
    void cambiarAltavoz();
    void planificarViaje(String destino,double duracion,double distancia);
}
