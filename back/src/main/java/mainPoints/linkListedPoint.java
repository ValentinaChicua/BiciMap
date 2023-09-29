package mainPoints;

public class linkListedPoint {
    nodePoint head;
    nodePoint tail;
    int size;

    public linkListedPoint() {
        head = null;
        tail = null;
        size = 0;
    }

    public void push(double latitud, double longitud) {
        nodePoint newNodePoint = new nodePoint(latitud, longitud);
        createPush(newNodePoint);
    }
    public void createPush(nodePoint newNodePoint){
        if (head == null) {
            head = newNodePoint;
            tail = head;
        } else {
            newNodePoint.setNext(head);
            head.setPrev(newNodePoint);
            head = newNodePoint;
        }
        size++;
    }

    public nodePoint find(double longi, double lat) {
        nodePoint current = head;
        while (current != null) {
            if (current.getLongitud() == longi && current.getLatitude() == lat) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public nodePoint pop(double longi, double lati) {
        nodePoint node = find(longi, lati);
        return createPop(node);
    }

    public nodePoint createPop(nodePoint node){
        if (node != null) {
            if (node.getPrev() != null) {
                node.getPrev().setNext(node.getNext());
            } else {
                head = node.getNext();
            }

            if (node.getNext() != null) {
                node.getNext().setPrev(node.getPrev());
            } else {
                tail = node.getPrev();
            }
            node.setPrev(null);
            node.setNext(null);
        }
        size--;
        return node;
    }

    public void AddAfter(nodePoint node, double lati, double longi) {
        nodePoint nuevo = new nodePoint(lati, longi);
        createAddAfter(node, nuevo);
    }

    public void createAddAfter(nodePoint node, nodePoint nuevo){
        size++;
        if (node != null) {
            if (node == tail) {
                tail.setNext(nuevo);
                nuevo.setPrev(tail);
                tail = nuevo;
            } else {
                node.getNext().setPrev(nuevo);
                nuevo.setNext(node.getNext());
                node.setNext(nuevo);
                nuevo.setPrev(node);
            }
        }
        System.out.println("El nodo ha sido añadido");
    }

    public void print(){
        nodePoint current= head;
        for(int i =0; i<size;i++){
            double longitud = current.getLongitud();
            double latitud = current.getLatitude();
            System.out.println("El "+ (i+1) + " coordenada del punto de reparacion es: " + longitud + " " + latitud);
            current = current.getNext();
        }

    }
}

