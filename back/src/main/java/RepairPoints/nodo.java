package RepairPoints;

public class nodo {
    double [] coordenada;
    int depth;
    nodo left;
    nodo right;
    public nodo(double[] coordenada, int depth) {
        this.coordenada=coordenada;
        this.depth=depth;
        this.left=null;
        this.right = null;
    }
}
