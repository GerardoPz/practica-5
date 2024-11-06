package app;

public class Experto {
    private String nombreExperto;
    private String especialidadExperto;
    private String areaDeInteres;
    private String ubicacionFija;
    private String contactoPersona;
    private String telefonoParaContactar;
    private AgendaExperto agendaExperto;

    public Experto(String nombreExperto, String especialidadExperto, String areaDeInteres, String ubicacionFija, String contactoPersona, String telefonoParaContactar) {
        this.nombreExperto = nombreExperto;
        this.especialidadExperto = especialidadExperto;
        this.areaDeInteres = areaDeInteres;
        this.ubicacionFija = ubicacionFija;
        this.contactoPersona = contactoPersona;
        this.telefonoParaContactar = telefonoParaContactar;
    }

    public String getNombreExperto() {
        return nombreExperto;
    }

    public void setNombreExperto(String nombreExperto) {
        this.nombreExperto = nombreExperto;
    }

    public String getEspecialidadExperto() {
        return especialidadExperto;
    }

    public void setEspecialidadExperto(String especialidadExperto) {
        this.especialidadExperto = especialidadExperto;
    }

    public String getAreaDeInteres() {
        return areaDeInteres;
    }

    public void setAreaDeInteres(String areaDeInteres) {
        this.areaDeInteres = areaDeInteres;
    }

    public String getUbicacionFija() {
        return ubicacionFija;
    }

    public void setUbicacionFija(String ubicacionFija) {
        this.ubicacionFija = ubicacionFija;
    }

    public String getContactoPersona() {
        return contactoPersona;
    }

    public void setContactoPersona(String contactoPersona) {
        this.contactoPersona = contactoPersona;
    }

    public String getTelefonoParaContactar() {
        return telefonoParaContactar;
    }

    public void setTelefonoParaContactar(String telefonoParaContactar) {
        this.telefonoParaContactar = telefonoParaContactar;
    }

    @Override
    public String toString() {
        return "Nombre Experto: " + nombreExperto + "\n" +
                "Especialidad Experto: " + especialidadExperto + "\n" +
                "Área De Interés: " + areaDeInteres + "\n" +
                "Ubicación Fija: " + ubicacionFija + "\n" +
                "Contacto Persona: " + contactoPersona + "\n" +
                "Teléfono Para Contactar: " + telefonoParaContactar;
    }
}
