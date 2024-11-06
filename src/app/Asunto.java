package app;

import java.time.LocalDate;

public class Asunto {
    private LocalDate fechaDeInicio;
    private LocalDate fechadeFin;
    private String ubicacion;
    private String actividad;
    private String encargadoDeAtencion;
    private String telefono;

    public Asunto() {
    }

    public Asunto(LocalDate fechaDeInicio, LocalDate fechadeFin, String ubicacion, String actividad, String encargadoDeAtencion, String telefono) {
        this.fechaDeInicio = fechaDeInicio;
        this.fechadeFin = fechadeFin;
        this.ubicacion = ubicacion;
        this.actividad = actividad;
        this.encargadoDeAtencion = encargadoDeAtencion;
        this.telefono = telefono;
    }

    public LocalDate getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(LocalDate fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public LocalDate getFechadeFin() {
        return fechadeFin;
    }

    public void setFechadeFin(LocalDate fechadeFin) {
        this.fechadeFin = fechadeFin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getEncargadoDeAtencion() {
        return encargadoDeAtencion;
    }

    public void setEncargadoDeAtencion(String encargadoDeAtencion) {
        this.encargadoDeAtencion = encargadoDeAtencion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
