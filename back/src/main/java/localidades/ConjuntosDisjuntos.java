package localidades;

import java.util.ArrayList;
import java.util.List;

public class ConjuntosDisjuntos {

    int[] parent;
    private int[] rank;
    PuntoPrincipal[] puntos;
    String[] localidades;
    int[][] coordenadasToConjunto;

    public ConjuntosDisjuntos(int n, PuntoPrincipal[] puntos) {
        parent = new int[n];
        rank = new int[n];
        this.puntos = puntos;
        localidades = new String[n];
        coordenadasToConjunto = new int[181][181];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
            localidades[i] = puntos[i].localidad;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public void unirConjuntos(ConjuntosDisjuntos conjuntos, PuntoPrincipal[] puntos) {
        for (int i = 0; i < puntos.length; i++) {
            for (int j = i + 1; j < puntos.length; j++) {
                if (puntosEnLaMismaLocalidad(puntos[i], puntos[j])) {
                    conjuntos.union(i, j);
                }
            }
        }
    }

    public static boolean puntosEnLaMismaLocalidad(PuntoPrincipal punto1, PuntoPrincipal punto2) {
        return punto1.localidad.equals(punto2.localidad);
    }

    public List<PuntoPrincipal> getPuntosPorLocalidadEspecifica(ConjuntosDisjuntos conjuntos, PuntoPrincipal[] puntos, String localidadDeseada) {
        int numConjuntos = conjuntos.parent.length;
        int[] localidadSizes = new int[numConjuntos];

        // Inicializa el tamaño de cada localidad
        for (int i = 0; i < numConjuntos; i++) {
            localidadSizes[i] = 0;
        }

        // Lista para almacenar los puntos de la localidad
        List<PuntoPrincipal> puntosLocalidadDeseada = new ArrayList<>();

        // Llena la lista de puntosLocalidadDeseada
        for (int i = 0; i < puntos.length; i++) {
            int conjunto = conjuntos.find(i);
            if (puntos[i].localidad.equals(localidadDeseada)) {
                puntosLocalidadDeseada.add(puntos[i]);
            }
        }
        return puntosLocalidadDeseada;
    }
}

//    public void imprimirPuntosPorLocalidadEspecifica(ConjuntosDisjuntos conjuntos, PuntoPrincipal[] puntos, String localidadDeseada) {
//        int numConjuntos = conjuntos.parent.length;
//        int[][] localidades = new int[numConjuntos][puntos.length];
//        int[] localidadSizes = new int[numConjuntos];
//
//        // Inicializa el tamaño de cada localidad
//        for (int i = 0; i < numConjuntos; i++) {
//            localidadSizes[i] = 0;
//        }
//
//        // Llena la matriz de localidades
//        for (int i = 0; i < puntos.length; i++) {
//            int conjunto = conjuntos.find(i);
//            localidades[conjunto][localidadSizes[conjunto]] = i;
//            localidadSizes[conjunto]++;
//        }
//
//        // Encuentra el conjunto de la localidad
//        int conjuntoLocalidadDeseada = -1;
//        for (int i = 0; i < numConjuntos; i++) {
//            if (localidadSizes[i] > 0) {
//                int puntoIndex = localidades[i][0];
//                PuntoPrincipal punto = puntos[puntoIndex];
//                if (punto.localidad.equals(localidadDeseada)) {
//                    conjuntoLocalidadDeseada = i;
//                    break;
//                }
//            }
//        }
//
//        // Imprime los puntos
//        if (conjuntoLocalidadDeseada != -1) {
//            System.out.println("Puntos de la localidad " + localidadDeseada + ":");
//            for (int j = 0; j < localidadSizes[conjuntoLocalidadDeseada]; j++) {
//                int puntoIndex = localidades[conjuntoLocalidadDeseada][j];
//                PuntoPrincipal punto = puntos[puntoIndex];
//                System.out.println("Latitud: " + punto.latitud + ", Longitud: " + punto.longitud);
//            }
//        }
//    }




