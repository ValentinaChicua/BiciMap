package com.example.BiciMap.servicio.RepairPoints;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class kdtree {
    private static final int K = 2;
    public  nodo root;
    public kdtree() {
        root = null;
    }
    public void insertarRutaDesdeCoordenada(Coordenada coordenada) {
        double latitud = coordenada.getLatitud();
        double longitud = coordenada.getLongitud();
        double[] coordenadaArray = {latitud, longitud};
        root = insert(root, coordenadaArray, 0);
    }

    public nodo insert(nodo node, double[] coordenada, int depth) {
        if (node == null) {
            return new nodo(coordenada, depth);
        }

        int axis = depth % K;
        if(coordenada[axis]<node.coordenada[axis]) {
            node.left = insert(node.left,coordenada,depth+1);
        }else {
            node.right=insert(node.right,coordenada,depth+1);
        }
        return node;
    }
    public List<double[]> obtenerPuntosCercanos(double latitud, double longitud, double radio) {
        List<double[]> puntosCercanos = new ArrayList<>();
        obtenerPuntosCercanos(root, latitud, longitud, radio, puntosCercanos);
        return puntosCercanos;
    }

    private void obtenerPuntosCercanos(nodo node, double latitud, double longitud, double radio, List<double[]> puntosCercanos) {
        if (node != null) {
            double distancia = haversine(latitud, longitud, node.coordenada[0], node.coordenada[1]);
            if (distancia <= radio) {
                puntosCercanos.add(node.coordenada);
            }
            // Explorar subárboles solo si es necesario
            if (node.left != null && (node.coordenada[0] - latitud) >= -radio) {
                obtenerPuntosCercanos(node.left, latitud, longitud, radio, puntosCercanos);
            }
            if (node.right != null && (node.coordenada[0] - latitud) <= radio) {
                obtenerPuntosCercanos(node.right, latitud, longitud, radio, puntosCercanos);
            }
        }
    }
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radio de la Tierra en kilómetros

        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);

        double deltaLat = Math.toRadians(lat2 - lat1);
        double deltaLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
    public void print(nodo nodo){

        if (nodo == null) {
            return;
        }

        // Recorre el subárbol izquierdo
        print(nodo.getLeft());

        // Imprime el valor del nodo actual
        System.out.println("Latitud: " + Arrays.toString(nodo.coordenada));

        // Recorre el subárbol derecho
        print(nodo.getRight());
    }
}