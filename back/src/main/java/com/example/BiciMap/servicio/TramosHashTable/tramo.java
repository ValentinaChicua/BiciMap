package com.example.BiciMap.servicio.TramosHashTable;

import com.example.BiciMap.servicio.RepairPoints.Coordenada;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
@Component
public class tramo {
    private static final int TAMANO = 14; // Tamaño inicial de la tabla hash
    private List<Entrada>[] tabla;

    public tramo() {
        this.tabla = new List[TAMANO];
        for (int i = 0; i < TAMANO; i++) {
            tabla[i] = new LinkedList<>();
        }
        inicializarTramos();
    }

    // Método para calcular el índice hash
    private int calcularIndiceHash(String clave) {
        int hashCode = clave.hashCode();
        return Math.abs(hashCode % TAMANO);
    }

    // Método para agregar una entrada a la tabla hash
    public void agregarEntrada(String clave, List<Coordenada> coordenadas) {
        int indice = calcularIndiceHash(clave);
        List<Entrada> lista = tabla[indice];

        // Verificar si la clave ya existe en la lista
        for (Entrada entrada : lista) {
            if (entrada.getClave().equals(clave)) {
                // Actualizar las coordenadas si la clave ya existe
                entrada.setCoordenadas(coordenadas);
                return;
            }
        }

        // Agregar una nueva entrada si la clave no existe
        lista.add(new Entrada(clave, coordenadas));
    }

    // Método para obtener las coordenadas de una clave
    public List<Coordenada> obtenerCoordenadas(String clave) {
        int indice = calcularIndiceHash(clave);
        List<Entrada> lista = tabla[indice];

        // Buscar la clave en la lista
        for (Entrada entrada : lista) {
            if (entrada.getClave().equals(clave)) {
                return entrada.getCoordenadas();
            }
        }

        // Retornar null si la clave no se encuentra
        return null;
    }
    private void inicializarTramos() {
        List<Coordenada> coordenadasPrimerTramo = List.of(
                new Coordenada(-74.08908, 4.576167),
                new Coordenada(-74.089135, 4.576089),
                new Coordenada(-74.090643, 4.577107),
                new Coordenada(-74.092522, 4.578269),
                new Coordenada(-74.092484, 4.578325),
                new Coordenada(-74.092756, 4.578528),
                new Coordenada(-74.092798, 4.57847),
                new Coordenada(-74.096343, 4.581654),
                new Coordenada(-74.09731, 4.58254),
                new Coordenada(-74.098306, 4.583419),
                new Coordenada(-74.098355, 4.583387),
                new Coordenada(-74.098717, 4.583577),
                new Coordenada(-74.098788, 4.583534),
                new Coordenada(-74.099428, 4.584236),
                new Coordenada(-74.100154, 4.584974),
                new Coordenada(-74.100592, 4.58545),
                new Coordenada(-74.100572, 4.585468),
                new Coordenada(-74.100632, 4.58553),
                new Coordenada(-74.100646, 4.585517),
                new Coordenada(-74.101118, 4.586012),
                new Coordenada(-74.101098, 4.586031),
                new Coordenada(-74.101179, 4.586112),
                new Coordenada(-74.101196, 4.586096),
                new Coordenada(-74.102099, 4.587038),
                new Coordenada(-74.102114, 4.587025),
                new Coordenada(-74.102134, 4.587046),
                new Coordenada(-74.10239, 4.587324),
                new Coordenada(-74.102533, 4.587184),
                new Coordenada(-74.102592, 4.587162),
                new Coordenada(-74.102656, 4.587187),
                new Coordenada(-74.102731, 4.587277),
                new Coordenada(-74.10281, 4.587374),
                new Coordenada(-74.10284, 4.587638),
                new Coordenada(-74.102824, 4.587716),
                new Coordenada(-74.102798, 4.587755),
                new Coordenada(-74.103668, 4.58868),
                new Coordenada(-74.104216, 4.589267),
                new Coordenada(-74.104463, 4.589039),
                new Coordenada(-74.104509, 4.589017),
                new Coordenada(-74.104558, 4.589042),
                new Coordenada(-74.104691, 4.589181),
                new Coordenada(-74.104921, 4.589421),
                new Coordenada(-74.104937, 4.589463),
                new Coordenada(-74.104871, 4.589546),
                new Coordenada(-74.104883, 4.589546),
                new Coordenada(-74.104871, 4.589546),
                new Coordenada(-74.104669, 4.589744),
                new Coordenada(-74.104866, 4.589951),
                new Coordenada(-74.10644, 4.591615),
                new Coordenada(-74.107371, 4.59292),
                new Coordenada(-74.108613, 4.594625),
                new Coordenada(-74.109247, 4.595517),
                new Coordenada(-74.109658, 4.596089),
                new Coordenada(-74.109795, 4.596275),
                new Coordenada(-74.109813, 4.5963),
                new Coordenada(-74.109258, 4.596695),
                new Coordenada(-74.10843, 4.597292),
                new Coordenada(-74.108391, 4.597252),
                new Coordenada(-74.108541, 4.596933),
                new Coordenada(-74.108567, 4.596945),
                new Coordenada(-74.108466, 4.59716),
                new Coordenada(-74.109463, 4.597623),
                new Coordenada(-74.109927, 4.597997),
                new Coordenada(-74.109667, 4.598114),
                new Coordenada(-74.109685, 4.598152),
                new Coordenada(-74.109947, 4.598035),
                new Coordenada(-74.109922, 4.598015),
                new Coordenada(-74.109993, 4.597928),
                new Coordenada(-74.110182, 4.598028),
                new Coordenada(-74.111087, 4.598473),
                new Coordenada(-74.113146, 4.599439),
                new Coordenada(-74.115073, 4.600371),
                new Coordenada(-74.115492, 4.600548),
                new Coordenada(-74.115599, 4.60062),
                new Coordenada(-74.115697, 4.60073),
                new Coordenada(-74.116453, 4.601952),
                new Coordenada(-74.116779, 4.602443),
                new Coordenada(-74.117357, 4.603241),
                new Coordenada(-74.117771, 4.6039),
                new Coordenada(-74.117977, 4.604297),
                new Coordenada(-74.118499, 4.60542),
                new Coordenada(-74.11894, 4.606332),
                new Coordenada(-74.119037, 4.606571)
        );


        agregarEntrada("Sur3", coordenadasPrimerTramo);

    }
}