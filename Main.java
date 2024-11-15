import java.util.Scanner;
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static RadioClaseA radio = new RadioClaseA();  
    private static int option = 0;
    public static void main(String[] args) {
        System.out.println("El radio esta apagado");
        System.out.println("Encender el radio (Si/No)");
        String respuesta = sc.nextLine();
        if (respuesta.equals("Si")) {
            radio.encender();
        }
        while (option != 2){
            if(radio.estaEncendido() && radio.getModo().equals("Radio")){
                menuRadio();
            }else{
                if(radio.estaEncendido() && radio.getModo().equals("Reproductor")){
                    menuReproductor();
                }else{
                    if(radio.estaEncendido() && radio.getModo().equals("Telefono")){
                        menuTelefono();
                    }else{
                        System.out.println("El radio esta apagado");
                    }
                }
            }
        }
    }

    private static void menuRadio(){
        System.out.println("-Menu Principal- \n¿Que desea realizar?");
        System.out.println("1. Encender el radio");
        System.out.println("2. Apagar el radio");
        System.out.println("3. Subir el volumen");
        System.out.println("4. Bajar el volumen");
        System.out.println("5. Cambiar Modo de reproduccion Radio/Reproductor/telefono");
        System.out.println("-Modo Radio-");
        System.out.println("6. Cambier frecuencia");
        System.out.println("7. Cambiar emisora");
        System.out.println("8. Guardar emisora Acutal");
        System.out.println("9. Reproducir emisora Guardada");
        System.out.println("¿Que desea realizar?");
        option = sc.nextInt();
        switch(option){
            case 1:
            radio.encender();
            break;
            case 2:
            radio.apagar();
            break;
            case 3:
            radio.aumentarVolumen();
            System.out.println("Volumen: " + radio.getVolumen());
            break;
            case 4:
            radio.disminuirVolumen();
            System.out.println("Volumen: " + radio.getVolumen());
            break;
            case 5:
            radio.cambiarModo();
            break; 
            case 6:
            radio.cambiarFrecuencia();
            System.out.println("frecuencia cambiada a " + radio.getFrecuencia());
            break;
            case 7:
            radio.cambiarEmisora();
            System.out.println("emisora cambiada a " + radio.getEmisora());
            break;
            case 8:
            radio.guardarEmisora();
            System.out.println("emisora guardada");
            break;
            case 9:
            System.out.println("seleccione una emisora");
            for(int i = 0; i < 50; i++){
               System.out.println(i+1 + " " + radio.getEmisorasGuardadas()[i]);
            }
            int choice = sc.nextInt();
            radio.cargarEmisora(choice);
            System.out.println("reproduciendo emisora: " + radio.getEmisora());
            break;

        }
    }

    private static void menuReproductor(){
        System.out.println("-Menu Principal- \n¿Que desea realizar?");
        System.out.println("1. Encender el radio");
        System.out.println("2. Apagar el radio");
        System.out.println("3. Subir el volumen");
        System.out.println("4. Bajar el volumen");
        System.out.println("5. Cambiar Modo de reproduccion Radio/Reproductor/telefono");
        System.out.println("-Modo Reproductor-");
        System.out.println("6. Seleccionar lista de reproducción");
        System.out.println("7. Reproducir cancion");
        System.out.println("8. Cambiar a siguente cancion");
        System.out.println("9. Mostrar informacion de la canción aactual");
        System.out.println("¿Que desea realizar?");
        option = sc.nextInt();
        switch(option){
            case 1:
            radio.encender();
            break;
            case 2:
            radio.apagar();
            break;
            case 3:
            radio.aumentarVolumen();
            System.out.println("Volumen: " + radio.getVolumen());
            break;
            case 4:
            radio.disminuirVolumen();
            System.out.println("Volumen: " + radio.getVolumen());
            break;
            case 5:
            radio.cambiarModo();
            break; 
            case 6:
            System.out.println("seleccione una lista de reproducción");
            for(ListaReproduccion lista : radio.getListas()){
                System.out.println(lista);
            }
            String choice = sc.nextLine();
            for(ListaReproduccion lista : radio.getListas()){
                if(choice.equals(lista.getNombre())){
                    radio.seleccionarLista(lista);
                }
            }
            break;
            case 7:
            System.out.println("seleccione una cancion");
            for(Cancion cancion : radio.getListaReproduccion().getCanciones()){
                System.out.println(cancion);
            }
            choice = sc.nextLine();
            for(Cancion cancion : radio.getListaReproduccion().getCanciones()){
                if(choice.equals(cancion.getNombre())){
                    radio.reproducirCancion(cancion);
                }
            }
            break;
            case 8:
            //radio.cambiarCancion();
            break;
            case 9:
            System.out.println("informacion de la cancion actual");
            System.out.println(radio.getCancion());
            break;
        }
    }

    private static void menuTelefono(){
        System.out.println("-Menu Principal- \n¿Que desea realizar?");
        System.out.println("1. Encender el radio");
        System.out.println("2. Apagar el radio");
        System.out.println("3. Subir el volumen");
        System.out.println("4. Bajar el volumen");
        System.out.println("5. Cambiar Modo de reproduccion Radio/Reproductor/telefono");
        System.out.println("-Modo Telefono-");
        System.out.println("6. Conectar telefono");
        System.out.println("7. Desconectar telefono");
        System.out.println("8. Mostrar contactos");
        System.out.println("9. Llamar a un contacto");
        System.out.println("10. Terminar Llamada");
        System.out.println("11. Cambiar altavoz");
        System.out.println("12. Planificar un viaje");
        System.out.println("¿Que desea realizar?");
        option = sc.nextInt();
        switch(option){
            case 1:
            radio.encender();
            break;
            case 2:
            radio.apagar();
            break;
            case 3:
            radio.aumentarVolumen();
            System.out.println("Volumen: " + radio.getVolumen());
            break;
            case 4:
            radio.disminuirVolumen();
            System.out.println("Volumen: " + radio.getVolumen());
            break;
            case 5:
            radio.cambiarModo();
            break; 
            case 6:
            if(radio.estaConectado()){
                System.out.println("telefono ya esta conectado");
            }else{
                radio.conectarTelefono();
            }
            break;
            case 7:
            if(radio.estaConectado()){
                radio.desconectarTelefono();
            }else{
                System.out.println("telefono no esta conectado");
            }
            break;
            case 8:
            System.out.println("contactos");
            break;
            case 9:
            System.out.println("seleccione un contacto");
            for(Contacto contacto : radio.getContactos()){
                System.out.println(contacto);
            }
            String choice = sc.nextLine();
            for(Contacto contacto : radio.getContactos()){
                if(choice.equals(contacto.getNombre())){
                    radio.llamarContacto(contacto);
                }
            }
            break;
            case 10:
            radio.finalizarLlamada();
            break;
            case 11:
            radio.cambiarAltavoz();
            break;
            case 12:
            System.out.println("ingrese el destino del viaje");
            String destino = sc.nextLine();
            System.out.println("ingrese la distancia del viaje");
            double distancia = sc.nextDouble();
            System.out.println("ingrese el tiempo del viaje");
            double tiempo = sc.nextDouble();
            radio.planificarViaje(destino, distancia, tiempo);
            System.out.println("viaje guardado exitosamente");
            break;
        }
    }
}
