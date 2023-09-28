package RepairPoints;

public class nodoRepairPoints {
    double latitud;
    double longitud;
    nodoRepairPoints next;
    nodoRepairPoints prev;

    public nodoRepairPoints(double latitud, double longitud){
        this.latitud= latitud;
        this.longitud = longitud;
        this.next = null;
        this.prev = null;

    }
    public void setNext(nodoRepairPoints next) {
        this.next = next;
    }
    public void setPrev(nodoRepairPoints prev) {
        this.prev =prev;
    }
    public nodoRepairPoints getNext() {
        return next;
    }
    public nodoRepairPoints getPrev() {
        return prev;
    }
    public double getLatitude() {
        return latitud;
    }
    public double getLongitud() {
        return longitud;
    }
}
