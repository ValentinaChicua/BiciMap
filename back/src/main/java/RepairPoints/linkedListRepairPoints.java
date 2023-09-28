package RepairPoints;

public class linkedListRepairPoints {
    nodoRepairPoints head;
    nodoRepairPoints tail;
    int size;
    public linkedListRepairPoints(){
        head = null;
        size=0;
        tail = null;
    }
    public void push(double longi, double lat){
        nodoRepairPoints newNodoRepairPoints = new nodoRepairPoints(longi,lat);
        if(head == null){
            head = newNodoRepairPoints;
            tail = head;
        }else{
            newNodoRepairPoints.setNext(head);
            head.setPrev(newNodoRepairPoints);
            head = newNodoRepairPoints;
        }
        size++;
    }
    public nodoRepairPoints find(double longi, double lat){
        nodoRepairPoints current = head;
        while(current != null){
            if(current.getLongitud() == longi && current.getLatitude()==lat){
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public nodoRepairPoints pop(double longi, double lati){
        nodoRepairPoints node = find(longi, lati);
        if(node != null){
            if(node.getPrev() !=null){
                node.getPrev().setNext(node.getNext());
            }else{
                head = node.getNext();
            }

            if(node.getNext()!= null){
                node.getNext().setPrev(node.getPrev());
            }else{
                tail = node.getPrev();
            }
            node.setPrev(null);
            node.setNext(null);
        }
        size--;
        return node;
    }
    public void AddAfter(nodoRepairPoints node, double lati, double longi){
        nodoRepairPoints nuevo = new nodoRepairPoints(lati,longi);
        size++;
        if(node!=null){
            if(node == tail){
                tail.setNext(nuevo);
                nuevo.setPrev(tail);
                tail = nuevo;
            }else{
                node.getNext().setPrev(nuevo);
                nuevo.setNext(node.getNext());
                node.setNext(nuevo);
                nuevo.setPrev(node);
            }
        }
        System.out.println("El nodo ha sido añadido");
    }

    public void print(){
        nodoRepairPoints current= head;
        for(int i =0; i<size;i++){
            double longitud = current.getLongitud();
            double latitud = current.getLatitude();
            System.out.println("El "+ (i+1) + " coordenada del punto de reparacion es: " + longitud + " " + latitud);
            current = current.getNext();
        }

    }
}
