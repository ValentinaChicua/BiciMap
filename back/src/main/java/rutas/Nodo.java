package rutas;

public class Nodo {
    String iniDireccion;
    String finDireccion;
    double latitudInicio;
    double longitudInicio;
    double latitudFin;
    double longitudFin;
    double km;
    Nodo next;

    public Nodo(String iniD, String finD,double latInicio, double lonInicio, double latFin, double lonFin, double km) {
        this.iniDireccion = iniD;
        this.finDireccion = finD;
        this.latitudInicio = latInicio;
        this.longitudInicio = lonInicio;
        this.latitudFin = latFin;
        this.longitudFin = lonFin;
        this.km = km;
        next = null;
    }
}
