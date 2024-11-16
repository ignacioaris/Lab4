// Ignacio Arís - 24380
// Adrian Corado - 24748
// laboratorio 4
/***
 * importar librerias necesarias para el funcionamiento del programa
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/***
 * Creacion de la clase Main
 */
public class MainGUI extends JFrame {

/***
 * Atributos estaticos de la clase
 */
    private static RadioClaseA radio;
    private static ArrayList<Cancion> canciones = new ArrayList<>();
        
/***
 * declaracion de los botones en la interfaz grafica
 */
        private JButton btnEncender, btnApagar, btnSubirVolumen, btnBajarVolumen, btnCambiarModo;
        private JButton btnCambiarFrecuencia, btnCambiarEmisora, btnGuardarEmisora, btnReproducirEmisora;
        private JButton btnSeleccionarLista, btnReproducirCancion, btnCambiarCancion, btnMostrarInfoCancion;
        private JButton btnConectarTelefono, btnDesconectarTelefono, btnMostrarContactos, btnLlamarContacto;
        private JButton btnTerminarLlamada, btnCambiarAltavoz, btnPlanificarViaje;
    
        private JTextArea txtArea;
    
        public MainGUI() {
            radio = new RadioClaseA();
            setTitle("Control de Radio");
            setSize(600, 700);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new FlowLayout());
    
            txtArea = new JTextArea(20, 40);
            txtArea.setEditable(false);
            add(new JScrollPane(txtArea));
    
/***
 * Definir el texto en los botones de la interfaz grafica
 */
            // Botones de control
            btnEncender = new JButton("Encender");
            btnApagar = new JButton("Apagar");
            btnSubirVolumen = new JButton("Subir Volumen");
            btnBajarVolumen = new JButton("Bajar Volumen");
            btnCambiarModo = new JButton("Cambiar Modo");
            
            // Botones de modo Radio
            btnCambiarFrecuencia = new JButton("Cambiar Frecuencia");
            btnCambiarEmisora = new JButton("Cambiar Emisora");
            btnGuardarEmisora = new JButton("Guardar Emisora");
            btnReproducirEmisora = new JButton("Reproducir Emisora Guardada");
    
            // Botones de modo Reproductor
            btnSeleccionarLista = new JButton("Seleccionar Lista");
            btnReproducirCancion = new JButton("Reproducir Canción");
            btnCambiarCancion = new JButton("Cambiar Canción");
            btnMostrarInfoCancion = new JButton("Mostrar Info Canción");
    
            // Botones de modo Teléfono
            btnConectarTelefono = new JButton("Conectar Teléfono");
            btnDesconectarTelefono = new JButton("Desconectar Teléfono");
            btnMostrarContactos = new JButton("Mostrar Contactos");
            btnLlamarContacto = new JButton("Llamar Contacto");
            btnTerminarLlamada = new JButton("Terminar Llamada");
            btnCambiarAltavoz = new JButton("Cambiar Altavoz");
            btnPlanificarViaje = new JButton("Planificar Viaje");
    
/***
 * Añadir botones al marco
 */
            add(btnEncender);
            add(btnApagar);
            add(btnSubirVolumen);
            add(btnBajarVolumen);
            add(btnCambiarModo);
            add(btnCambiarFrecuencia);
            add(btnCambiarEmisora);
            add(btnGuardarEmisora);
            add(btnReproducirEmisora);
            add(btnSeleccionarLista);
            add(btnReproducirCancion);
            add(btnCambiarCancion);
            add(btnMostrarInfoCancion);
            add(btnConectarTelefono);
            add(btnDesconectarTelefono);
            add(btnMostrarContactos);
            add(btnLlamarContacto);
            add(btnTerminarLlamada);
            add(btnCambiarAltavoz);
            add(btnPlanificarViaje);


/**
 * Asignar acciones a los botones
 */

 /***
 * botones y acciones de metodos principales
 */
            btnEncender.addActionListener(e -> {
                radio.encender();
                updateTextArea();
            });
    
            btnApagar.addActionListener(e -> {
                radio.apagar();
                updateTextArea();
            });
    
            btnSubirVolumen.addActionListener(e -> {
                if(radio.estaEncendido()){
                radio.aumentarVolumen();
                }else{
                    JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
                }
                updateTextArea();
            });
    
            btnBajarVolumen.addActionListener(e -> {
                if(radio.estaEncendido()){
                radio.disminuirVolumen();
                }else{
                    JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
                }
                updateTextArea();
            });
    
            btnCambiarModo.addActionListener(e -> {
                if(radio.estaEncendido()){
                radio.cambiarModo();
                }else{
                    JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
                }
                updateTextArea();
            });

 /***
 * botones y acciones de metodos de modo 'Radio'
 */
            btnCambiarFrecuencia.addActionListener(e -> {
                if(radio.estaEncendido() && radio.getModo().equals("Radio")){
                radio.cambiarFrecuencia();
                }else{
                    JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
                }
                updateTextArea();
            });
    
            btnCambiarEmisora.addActionListener(e -> {
                if(radio.estaEncendido() && radio.getModo().equals("Radio")){
                radio.cambiarEmisora();
                }else{
                    JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
                }
                updateTextArea();
            });
    
            btnGuardarEmisora .addActionListener(e -> {
                if(radio.estaEncendido()&& radio.getModo().equals("Radio")){
                radio.guardarEmisora();
                }else{
                    JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
                }
                updateTextArea();
            });
    
            btnReproducirEmisora.addActionListener(e -> {
                if(radio.estaEncendido()&& radio.getModo().equals("Radio")){
                String choice = JOptionPane.showInputDialog("Seleccione una emisora guardada (1-50):");
                int index = Integer.parseInt(choice) - 1;
                radio.cargarEmisora(index);
                }else{
                    JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
                }
                updateTextArea();
            });

 /***
 * botones y acciones de metodos de modo 'Reproductor'
 */
            btnSeleccionarLista.addActionListener(e -> {
                if(radio.estaEncendido() && radio.getModo().equals("Reproductor")){
                String nombreLista = JOptionPane.showInputDialog("Ingrese el nombre de la lista de reproducción:");
                for (ListaReproduccion lista : radio.getListas()) {
                    if (nombreLista.equals(lista.getNombre())) {
                        radio.seleccionarLista(lista);
                        break;
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
            }
                updateTextArea();
            });
    
            btnReproducirCancion.addActionListener(e -> {
                if(radio.estaEncendido() && radio.getModo().equals("Reproductor")){
                radio.reproducirCancion();
                }else{
                    JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
                }
                updateTextArea();
            });
    
            btnCambiarCancion.addActionListener(e -> {
                if(radio.estaEncendido() && radio.getModo().equals("Reproductor")){
                radio.cambiarCancion();
                }else{
                    JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
                }
                updateTextArea();
            });
    
            btnMostrarInfoCancion.addActionListener(e -> {
                if(radio.estaEncendido() && radio.getModo().equals("Reproductor")){
                JOptionPane.showMessageDialog(this, "Información de la canción actual: " + radio.getCancion());
                }else{
                    JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
                }
            });

 /***
 * botones y acciones de metodos de modo 'Telefono'
 */
            btnConectarTelefono.addActionListener(e -> {
                if(radio.estaEncendido() && radio.getModo().equals("Telefono")){
                if (!radio.estaConectado()) {
                    radio.conectarTelefono();
                } else {
                    JOptionPane.showMessageDialog(this, "El teléfono ya está conectado.");
                }
            }else{
                JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
            }
                updateTextArea();
            });
    
            btnDesconectarTelefono.addActionListener(e -> {
                if(radio.estaEncendido() && radio.getModo().equals("Telefono")){
                if (radio.estaConectado()) {
                    radio.desconectarTelefono();
                } else {
                    JOptionPane.showMessageDialog(this, "El teléfono no está conectado.");
                }
            }else{
                JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
            }
                updateTextArea();
            });
    
            btnMostrarContactos.addActionListener(e -> {
                if(radio.estaEncendido() && radio.getModo().equals("Telefono")){
                StringBuilder contactos = new StringBuilder("Contactos:\n");
                for (Contacto contacto : radio.getContactos()) {
                    contactos.append(contacto.getNombre()).append("\n");
                }
                JOptionPane.showMessageDialog(this, contactos.toString());
            }else{
                JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
            }
            });
    
            btnLlamarContacto.addActionListener(e -> {
                if(radio.estaEncendido() && radio.getModo().equals("Telefono")){
                String nombreContacto = JOptionPane.showInputDialog("Ingrese el nombre del contacto:");
                for (Contacto contacto : radio.getContactos()) {
                    if (nombreContacto.equals(contacto.getNombre())) {
                        radio.llamarContacto(contacto);
                        break;
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
            }
                updateTextArea();
            });
    
            btnTerminarLlamada.addActionListener(e -> {
                if(radio.estaEncendido() && radio.getModo().equals("Telefono")){
                radio.finalizarLlamada();
                }else{
                    JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
                }
                updateTextArea();
            });
    
            btnCambiarAltavoz.addActionListener(e -> {
                if(radio.estaEncendido() && radio.getModo().equals("Telefono")){
                radio.cambiarAltavoz();
                }else{
                    JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
                }
                updateTextArea();
            });
    
            btnPlanificarViaje.addActionListener(e -> {
                if(radio.estaEncendido() && radio.getModo().equals("Telefono")){
                String destino = JOptionPane.showInputDialog("Ingrese el destino del viaje:");
                double distancia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la distancia del viaje en km:"));
                double tiempo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el tiempo del viaje en minutos:"));
                radio.planificarViaje(destino, distancia, tiempo);
                JOptionPane.showMessageDialog(this, "Viaje guardado exitosamente.");
                }else{
                    JOptionPane.showMessageDialog(this, "El radio esta apagado o en otro modo");
                }
                updateTextArea();
            });
        }

 /***
 * metodo para mostrar texto en pantalla
 */
        private void updateTextArea() {
            txtArea.setText("Estado del Radio:\n");
            txtArea.append("Encendido: " + radio.estaEncendido() + "\n");
            txtArea.append("Modo: " + radio.getModo() + "\n");
            txtArea.append("Volumen: " + radio.getVolumen() + "\n");
            txtArea.append("Frecuencia: " + radio.getFrecuencia() + "\n");
            txtArea.append("Emisora: " + radio.getEmisora() + "\n");
            
            if (radio.getListaReproduccion() != null) {
                txtArea.append("Lista de Reproducción: " + radio.getListaReproduccion().getNombre() + "\n");
            } else {
                txtArea.append("Lista de Reproducción: Ninguna seleccionada\n");
            }
        
            if (radio.getCancion() != null) {
                txtArea.append("Canción: " + radio.getCancion().getNombre() + "\n");
            } else {
                txtArea.append("Canción: Ninguna reproduciéndose\n");
            }
        
            txtArea.append("Teléfono conectado: " + radio.estaConectado() + "\n");
            txtArea.append("Altavoz: " + radio.isAltavoz() + "\n");
        }
    
 /***
 * metodo Main
 */
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                MainGUI gui = new MainGUI();
                cargarContactosCSV(radio);
                cargarCancionesCSV();
                gui.setVisible(true);
            });
        }

 /***
 * Metodos para cargar informacion desde archivos CSV
 */
        private static void cargarContactosCSV(RadioClaseA radio) {
            try (BufferedReader br = new BufferedReader(new FileReader("contactos.csv"))) {
                br.readLine(); // Salta la cabecera
        
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(",");
                    String nombre = datos[0];
                    String telefono = datos[1];
        
                    radio.getContactos().add(new Contacto(nombre, telefono));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private static void cargarCancionesCSV(){
            try (BufferedReader br = new BufferedReader(new FileReader("canciones.csv"))) {
                br.readLine(); // Salta la cabecera
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(",");
                    String nombre = datos[0];
                    String artista = datos[1];
                    double duracion = Double.parseDouble(datos[2]);

                    Cancion cancion = new Cancion(nombre, artista, duracion);
                    canciones.add(cancion);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            ListaReproduccion favoritas = new ListaReproduccion("favoritas",canciones);
            radio.agregarLista(favoritas);
        }
}