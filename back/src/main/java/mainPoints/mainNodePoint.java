package mainPoints;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class mainNodePoint extends linkListedPoint {
    public void push(double latitud, double longitud, String nombre) {
        nodePoint newNodePoint = new nodePoint(latitud, longitud, nombre);
        createPush(newNodePoint);
    }


    public nodePoint find(double longi, double lat, String nombre) {
        nodePoint current = head;
        while (current != null) {
            if (current.getLongitud() == longi && current.getLatitude() == lat || current.getNombre().equals(nombre)) {
                return current;
                }
            current = current.getNext();
            }
        return null;
    }

    public nodePoint pop(double longi, double lati, String nombre){
        nodePoint node = find(longi, lati, nombre);
        return createPop(node);

    }
    public void AddAfter(nodePoint node, double lati, double longi, String nombre) {
        nodePoint nuevo = new nodePoint(lati, longi, nombre);
        createAddAfter(node, nuevo);
    }
    public void print(){
        nodePoint current= head;
        for(int i =0; i<size;i++){
            double longitud = current.getLongitud();
            double latitud = current.getLatitude();
            String nombre = current.getNombre();
            System.out.println("La "+ (i+1) + " coordenada del punto " + nombre + " es: " + longitud + " " + latitud);
            current = current.getNext();
            }

    }

}
