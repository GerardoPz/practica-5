import ito.ExcepcionDeElementoNoEncontrado;
import ito.ExcepcionDeListaLlena;
import ito.ExcepcionDeListaVacia;

import javax.swing.*;

public class Main {
    static MyApp app = new MyApp();
    static String[] opcionesInicio = {"Ingresar A Mi Agenda", "Agregar Nuevo Experto", "SALIR"};
    static String[] opciones = {"Agregar Asunto A La Agenda", "Mostrar Agenda", "SALIR"};

    public static void menu(String nombre) throws ExcepcionDeListaLlena, ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
        String opcion;
        do {
            opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion", "Sistema Unidad 1", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            switch (opcion) {
                case "Agregar Asunto A La Agenda":
                    app.agregarAsuntoAgenda(nombre);
                    break;
                case "Mostrar Agenda":
                    app.mostrarAgenda(nombre);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "HASTA LUEGO");
            }
        } while (!opcion.equals("SALIR"));
    }

    public static void run() throws ExcepcionDeListaLlena, ExcepcionDeListaVacia {
        String opcionIncio;
        do {
            opcionIncio = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion", "Sistema Unidad 1", JOptionPane.QUESTION_MESSAGE, null, opcionesInicio, opciones[0]);
            switch (opcionIncio) {
                case "Ingresar A Mi Agenda":
                    app.ingresarAgenda();


                    break;
                case "Agregar Nuevo Experto":
                    app.agregarExperto();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "HASTA LUEGO");
            }
        } while (!opcionIncio.equals("SALIR"));
    }

    public static void main(String[] args) throws ExcepcionDeListaLlena, ExcepcionDeListaVacia {
        run();
    }
}
