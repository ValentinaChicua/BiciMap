package rutas.segundaEntrega;

public class NodoActual2 {
    String iniDireccion;
    String finDireccion;
    String latitudInicio;
    String longitudInicio;
    String latitudFin;
    String longitudFin;
    double km;
    NodoActual2 next;

    public NodoActual2(String iniD, String finD, String latInicio, String lonInicio, String latFin, String lonFin, double km) {
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






