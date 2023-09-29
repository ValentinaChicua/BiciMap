package mainPoints;

public class nodePoint {

    nodePoint next;
    nodePoint prev;
    protected double longitud;
    protected double latitud;
    protected String nombre;

    public nodePoint(double longitud, double latitud){
        this.longitud = longitud;
        this.latitud = latitud;
        this.next = null;
        this.prev = null;
    }
    public nodePoint(double longitud, double latitud, String nombre){
        this.longitud = longitud;
        this.latitud = latitud;
        this.next = null;
        this.prev = null;
        this.nombre = nombre;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public nodePoint getNext() {
        return next;
    }

    public nodePoint getPrev() {
        return prev;
    }

    public double getLatitude() {
        return latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setNext(nodePoint next) {
        this.next = next;
    }

    public void setPrev(nodePoint prev) {
        this.prev = prev;
    }


}
