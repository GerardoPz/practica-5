package app;

import ito.ExcepcionDeElementoNoEncontrado;
import ito.ExcepcionDeListaVacia;
import ito.ListaDinamica;

public class AgendaExperto {
    ListaDinamica<Asunto> agenda = new ListaDinamica<>();

    public AgendaExperto(ListaDinamica<Asunto> agenda) {
        this.agenda = agenda;
    }

    public ListaDinamica<Asunto> getAgenda() {
        return agenda;
    }

    public void setAgenda(ListaDinamica<Asunto> agenda) {
        this.agenda = agenda;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AgendaExperto{\n");

        // Recorremos cada elemento de la lista usando size() y getItem(i)
        for (int i = 0; i < agenda.size(); i++) {
            try {
                Asunto asunto = agenda.getItem(i); // Accedemos al i-ésimo elemento
                sb.append("  Asunto{" +
                        "fechaDeInicio=" + asunto.getFechaDeInicio() +
                        ", fechadeFin=" + asunto.getFechadeFin() +
                        ", ubicacion='" + asunto.getUbicacion() + '\'' +
                        ", actividad='" + asunto.getActividad() + '\'' +
                        ", encargadoDeAtencion='" + asunto.getEncargadoDeAtencion() + '\'' +
                        ", telefono='" + asunto.getTelefono() + '\'' +
                        "}\n");
            } catch (ExcepcionDeListaVacia | ExcepcionDeElementoNoEncontrado e) {
                // En caso de que haya un error con getItem, lo gestionamos aquí
                sb.append("  Error al acceder al asunto en la posición " + i + ": " + e.getMessage() + "\n");
            }
        }

        sb.append('}');
        return sb.toString();
    }

}
