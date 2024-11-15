public class Contacto{

    private String nombre;
    private String telefono;

    public Contacto(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre(){
        return this.nombre;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + "\nTelefono: " + telefono;
    }
}