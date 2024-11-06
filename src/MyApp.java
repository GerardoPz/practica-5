import app.AgendaExperto;
import app.Asunto;
import app.Calendario;
import app.Experto;
import ito.ExcepcionDeElementoNoEncontrado;
import ito.ExcepcionDeListaLlena;
import ito.ExcepcionDeListaVacia;
import ito.ListaDinamica;
import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyApp {
    private AgendaExperto agendaExperto;

    public MyApp() {
        this.agendaExperto = new AgendaExperto(new ListaDinamica<Asunto>());
    }

    public static void ingresarAgenda() {
        String nombreExperto = JOptionPane.showInputDialog("Ingrese el nombre del experto:");
        String nombreArchivo = nombreExperto.replaceAll("[^a-zA-Z0-9_]", "_") + ".txt";
        String projectPath = System.getProperty("user.dir"); // Obtiene la ruta del directorio actual
        String expertosPath = projectPath + File.separator + "src" + File.separator + "expertos" + File.separator + nombreArchivo;
        File archivoExperto = new File(expertosPath);
        if (archivoExperto.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivoExperto))) {
                String linea;
                StringBuilder contenido = new StringBuilder();
                while ((linea = reader.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                JOptionPane.showMessageDialog(null, contenido.toString());
                Main main = new Main();
                main.menu(nombreExperto);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
            } catch (ExcepcionDeListaLlena e) {
                throw new RuntimeException(e);
            } catch (ExcepcionDeListaVacia e) {
                throw new RuntimeException(e);
            } catch (ExcepcionDeElementoNoEncontrado e) {
                throw new RuntimeException(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un experto con el nombre: " + nombreExperto);
        }
    }

    public static void agregarExperto() {
        String nombreExperto = JOptionPane.showInputDialog("Nombre del experto");
        String especialidadExperto = JOptionPane.showInputDialog("Especialidad");
        String areaDeInteres = JOptionPane.showInputDialog("Área de Interés del Experto");
        String ubicacionFija = JOptionPane.showInputDialog("Ubicación del experto");
        String personaParaContactar = JOptionPane.showInputDialog("Persona Para Contactar");
        String telefonoContacto = JOptionPane.showInputDialog("Teléfono de contacto");
        Experto experto = new Experto(nombreExperto, especialidadExperto, areaDeInteres, ubicacionFija, personaParaContactar, telefonoContacto);
        System.out.println(experto.toString());
        guardarExpertoEnArchivo(experto);
    }

    public static void guardarExpertoEnArchivo(Experto experto) {
        String projectPath = System.getProperty("user.dir"); // Obtiene la ruta del directorio actual
        String expertosPath = projectPath + File.separator + "src" + File.separator + "expertos" + File.separator;
        String nombreArchivo = experto.getNombreExperto().replaceAll("[^a-zA-Z0-9_]", "_");
        File archivo = new File(expertosPath + nombreArchivo + ".txt");
        File carpetaExpertos = new File(expertosPath);
        if (!carpetaExpertos.exists()) {
            carpetaExpertos.mkdirs();
        }
        if (!archivo.exists()) {
            try {
                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado: " + archivo.getName());
                } else {
                    System.out.println("El archivo ya existe.");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el archivo: " + e.getMessage());
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(experto.toString());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el experto: " + e.getMessage());
        }
    }

    public void agregarAsuntoAgenda(String nombreExperto) throws ExcepcionDeListaLlena, ExcepcionDeListaVacia {
        Asunto asunto = new Asunto();
        Calendario app = new Calendario();
        LocalDate fechaInicio = app.showCalendarAndGetDate();
        LocalDate fechaFin = app.showCalendarAndGetDate();
        String ubicacion = JOptionPane.showInputDialog("Ingrese la ubicación");
        String actividadRealizar = JOptionPane.showInputDialog("Actividad que realizará");
        String encargado = JOptionPane.showInputDialog(null, "Encargado de su atención");
        String telefono = JOptionPane.showInputDialog(null, "Número de Contacto");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        asunto.setFechaDeInicio(fechaInicio);
        asunto.setFechadeFin(fechaFin);
        asunto.setUbicacion(ubicacion);
        asunto.setActividad(actividadRealizar);
        asunto.setEncargadoDeAtencion(encargado);
        asunto.setTelefono(telefono);
        String projectPath = System.getProperty("user.dir"); // Ruta del proyecto
        String expertosPath = projectPath + File.separator + "src" + File.separator + "expertos";
        String nombreArchivo = expertosPath + File.separator + nombreExperto.replaceAll("[^a-zA-Z0-9_]", "_") + ".txt";
        File archivoExperto = new File(nombreArchivo);
        if (archivoExperto.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoExperto, true))) {
                writer.newLine();
                writer.write("Nuevo Asunto: ");
                writer.newLine();
                writer.write("Fecha de Inicio: " + asunto.getFechaDeInicio().format(formatter));
                writer.newLine();
                writer.write("Fecha de Fin: " + asunto.getFechadeFin().format(formatter));
                writer.newLine();
                writer.write("Ubicación: " + asunto.getUbicacion());
                writer.newLine();
                writer.write("Actividad: " + asunto.getActividad());
                writer.newLine();
                writer.write("Encargado de Atención: " + asunto.getEncargadoDeAtencion());
                writer.newLine();
                writer.write("Teléfono de Contacto: " + asunto.getTelefono());
                writer.newLine();
                JOptionPane.showMessageDialog(null, "Asunto agregado a la agenda del experto.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al agregar el asunto: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un archivo de experto para agregar el asunto.");
        }
    }

    public void mostrarAgenda(String nombreExperto) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
        String projectPath = System.getProperty("user.dir"); // Ruta del proyecto
        String expertosPath = projectPath + File.separator + "src" + File.separator + "expertos";
        String nombreArchivo = expertosPath + File.separator + nombreExperto.replaceAll("[^a-zA-Z0-9_]", "_") + ".txt";
        File archivoExperto = new File(nombreArchivo);
        if (!archivoExperto.exists()) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo del experto.");
            return;
        }
        ListaDinamica asuntos = new ListaDinamica(); // Usamos tu clase ListaDinamica
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoExperto))) {
            String line;
            StringBuilder asunto = new StringBuilder();
            boolean enAsunto = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Nuevo Asunto:")) {
                    if (enAsunto) {
                        asuntos.add(asunto.toString());
                    }
                    asunto.setLength(0);
                    enAsunto = true;
                    asunto.append("Nuevo Asunto:\n");
                }
                asunto.append(line).append("\n");
            }
            if (enAsunto) {
                asuntos.add(asunto.toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo del experto: " + e.getMessage());
            e.printStackTrace();
        } catch (ExcepcionDeListaLlena e) {
            throw new RuntimeException(e);
        }
        if (asuntos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La agenda del experto está vacía.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Agenda del Experto ").append(nombreExperto).append(":\n");
        for (int i = 0; i < asuntos.size(); i++) {
            String asuntoString = (String) asuntos.getItem(i); // Usamos tu método 'obtener' para recuperar el asunto
            sb.append("\nAsunto ").append(i + 1).append(":\n");
            sb.append(asuntoString); // Agregar el texto del asunto
            sb.append("----------------------------\n");
        }
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(500, 300));
        JOptionPane.showMessageDialog(null, scrollPane, "Agenda del Experto", JOptionPane.INFORMATION_MESSAGE);
    }
}