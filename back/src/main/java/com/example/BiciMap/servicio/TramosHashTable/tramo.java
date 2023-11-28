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

        List<Coordenada> coordenadasSegundoTramo = List.of(

                new  Coordenada(-74.126691, 4.594293),
                new  Coordenada(-74.12662, 4.594338),
                new  Coordenada(-74.126562, 4.594477),
                new  Coordenada(-74.126479, 4.594835),
                new  Coordenada(-74.126355, 4.595366),
                new  Coordenada(-74.126316, 4.595529),
                new  Coordenada(-74.126292, 4.595625),
                new Coordenada(-74.126215, 4.595932),
                new Coordenada(-74.126097, 4.596398),
                new Coordenada(-74.12597, 4.596714),
                new Coordenada(-74.125929, 4.596816),
                new Coordenada(-74.1258, 4.597045),
                new Coordenada(-74.125677, 4.597257),
                new Coordenada(-74.125532, 4.597451),
                new Coordenada(-74.125213, 4.597845),
                new Coordenada(-74.125018, 4.598076),
                new Coordenada(-74.124983, 4.598118),
                new Coordenada(-74.124865, 4.59826),
                new Coordenada(-74.124189, 4.599078),
                new Coordenada(-74.123854, 4.599487),
                new Coordenada(-74.123403, 4.600041),
                new Coordenada(-74.122738, 4.600861),
                new Coordenada(-74.122464, 4.601198),
                new Coordenada(-74.122169, 4.601566),
                new Coordenada(-74.12197, 4.601807),
                new Coordenada(-74.121921, 4.601886),
                new Coordenada(-74.121856, 4.602052),
                new Coordenada(-74.121843, 4.602131),
                new Coordenada(-74.121809, 4.602426),
                new Coordenada(-74.121808, 4.602431),
                new Coordenada(-74.121822, 4.60257),
                new Coordenada(-74.121804, 4.602694),
                new Coordenada(-74.121763, 4.602791),
                new Coordenada(-74.121671, 4.60292),
                new Coordenada(-74.121566, 4.603001),
                new Coordenada(-74.121444, 4.603053),
                new Coordenada(-74.121368, 4.603064),
                new Coordenada(-74.121312, 4.603072),
                new Coordenada(-74.121157, 4.60316),
                new Coordenada(-74.120966, 4.603312),
                new Coordenada(-74.120819, 4.603538),
                new Coordenada(-74.120631, 4.603868),
                new Coordenada(-74.120472, 4.604168),
                new Coordenada(-74.120303, 4.604487),
                new Coordenada(-74.120066, 4.604932),
                new Coordenada(-74.119847, 4.60534),
                new Coordenada(-74.119666, 4.605678),
                new Coordenada(-74.119398, 4.606176),
                new Coordenada(-74.11939, 4.606158),
                new Coordenada(-74.119398, 4.606176),
                new Coordenada(-74.119197, 4.606559),
                new Coordenada(-74.119026, 4.606871),
                new Coordenada(-74.118671, 4.607507),
                new Coordenada(-74.118456, 4.607891),
                new Coordenada(-74.118119, 4.608489),
                new Coordenada(-74.117928, 4.608829),
                new Coordenada(-74.117407, 4.609759),
                new Coordenada(-74.117215, 4.610102),
                new Coordenada(-74.116651, 4.611101),
                new Coordenada(-74.116173, 4.61203),
                new Coordenada(-74.115805, 4.612755),
                new Coordenada(-74.115623, 4.613122),
                new Coordenada(-74.115162, 4.614058),
                new Coordenada(-74.11512, 4.614143),
                new Coordenada(-74.115056, 4.614349),
                new Coordenada(-74.115055, 4.614693),
                new Coordenada(-74.114993, 4.614618),
                new Coordenada(-74.114918, 4.614556),
                new Coordenada(-74.114811, 4.614502),
                new Coordenada(-74.114644, 4.614468),
                new Coordenada(-74.114546, 4.614474),
                new Coordenada(-74.11447, 4.614492),
                new Coordenada(-74.114335, 4.614559),
                new Coordenada(-74.114277, 4.614606),
                new Coordenada(-74.114183, 4.614724),
                new Coordenada(-74.114118, 4.614919),
                new Coordenada(-74.114126, 4.615052),
                new Coordenada(-74.114129, 4.615101),
                new Coordenada(-74.114178, 4.615229),
                new Coordenada(-74.114292, 4.615369),
                new Coordenada(-74.114427, 4.615453),
                new Coordenada(-74.114581, 4.615492),
                new Coordenada(-74.114509, 4.615527),
                new Coordenada(-74.114453, 4.615587),
                new Coordenada(-74.11392, 4.616829),
                new Coordenada(-74.113554, 4.617678),
                new Coordenada(-74.113288, 4.618286),
                new Coordenada(-74.113174, 4.618498),
                new Coordenada(-74.112894, 4.618987),
                new Coordenada(-74.112827, 4.619109),
                new Coordenada(-74.112643, 4.619414),
                new Coordenada(-74.112393, 4.619739),
                new Coordenada(-74.111937, 4.620311),
                new Coordenada(-74.111602, 4.620718),
                new Coordenada(-74.110809, 4.621715),
                new Coordenada(-74.110713, 4.621835),
                new Coordenada(-74.110504, 4.622192),
                new Coordenada(-74.110504, 4.622192),
                new Coordenada(-74.110358, 4.622441),
                new Coordenada(-74.110016, 4.623105),
                new Coordenada(-74.109737, 4.623586),
                new Coordenada(-74.109616, 4.623763),
                new Coordenada(-74.109071, 4.624472),
                new Coordenada(-74.108276, 4.625457),
                new Coordenada(-74.107985, 4.625842),
                new Coordenada(-74.107502, 4.626479)
        );
        agregarEntrada("Centro2", coordenadasSegundoTramo);

    List<Coordenada> coordenadasTercerTramo = List.of(
            new Coordenada(-74.089834, 4.634511),
            new Coordenada(-74.090437, 4.634746),
            new Coordenada(-74.090741, 4.634916),
            new Coordenada(-74.09108, 4.635135),
            new Coordenada(-74.091364, 4.635368),
            new Coordenada(-74.091518, 4.635515),
            new Coordenada(-74.091749, 4.635778),
            new Coordenada(-74.091848, 4.6359),
            new Coordenada(-74.092517, 4.636884),
            new Coordenada(-74.093398, 4.638262),
            new Coordenada(-74.09401, 4.639083),
            new Coordenada(-74.094859, 4.640413),
            new Coordenada(-74.095495, 4.64141),
            new Coordenada(-74.095821, 4.642017),
            new Coordenada(-74.098422, 4.646145),
            new Coordenada(-74.098915, 4.646982),
            new Coordenada(-74.099336, 4.647603),
            new Coordenada(-74.099601, 4.647473),
            new Coordenada(-74.098763, 4.646117),
            new Coordenada(-74.098161, 4.645093),
            new Coordenada(-74.09621, 4.642072),
            new Coordenada(-74.095768, 4.64146),
            new Coordenada(-74.094778, 4.639989),
            new Coordenada(-74.093902, 4.638508),
            new Coordenada(-74.093721, 4.638233),
            new Coordenada(-74.092611, 4.636323),
            new Coordenada(-74.092399, 4.636023),
            new Coordenada(-74.092108, 4.635681),
            new Coordenada(-74.091831, 4.635395),
            new Coordenada(-74.091397, 4.635022),
            new Coordenada(-74.091213, 4.634893),
            new Coordenada(-74.090802, 4.634643),
            new Coordenada(-74.090038, 4.634257),
            new Coordenada(-74.08986, 4.634192),
            new Coordenada(-74.089094, 4.633911),
            new Coordenada(-74.087825, 4.633439),
            new Coordenada(-74.086198, 4.632909),
            new Coordenada(-74.085635, 4.632719),
            new Coordenada(-74.085382, 4.632619),
            new Coordenada(-74.085138, 4.632493),
            new Coordenada(-74.084989, 4.632396),
            new Coordenada(-74.084695, 4.632164),
            new Coordenada(-74.084342, 4.631815),
            new Coordenada(-74.083877, 4.631168),
            new Coordenada(-74.082581, 4.629221),
            new Coordenada(-74.082201, 4.628598),
            new Coordenada(-74.081527, 4.627631),
            new Coordenada(-74.081282, 4.627277),
            new Coordenada(-74.080845, 4.62656),
            new Coordenada(-74.080362, 4.625857),
            new Coordenada(-74.079624, 4.624831),
            new Coordenada(-74.079366, 4.62445),
            new Coordenada(-74.078717, 4.623512),
            new Coordenada(-74.078363, 4.62302),
            new Coordenada(-74.077655, 4.622037),
            new Coordenada(-74.077157, 4.621424),
            new Coordenada(-74.075308, 4.618784),
            new Coordenada(-74.074138, 4.617061),
            new Coordenada(-74.073974, 4.616748),
            new Coordenada(-74.073197, 4.615621),
            new Coordenada(-74.073096, 4.615439),
            new Coordenada(-74.073081, 4.615355),
            new Coordenada(-74.073101, 4.615242)
    );
    agregarEntrada("Centro4", coordenadasTercerTramo);

        List<Coordenada> coordenadasCuartoTramo = List.of(
                new Coordenada(-74.126613, 4.685773),
                new Coordenada(-74.124152, 4.683891),
                new Coordenada(-74.123475, 4.683391),
                new Coordenada(-74.12324, 4.683201),
                new Coordenada(-74.123006, 4.682977),
                new Coordenada(-74.122819, 4.682771),
                new Coordenada(-74.122585, 4.68248),
                new Coordenada(-74.120159, 4.679103),
                new Coordenada(-74.117614, 4.67516),
                new Coordenada(-74.117422, 4.674908),
                new Coordenada(-74.117208, 4.674673),
                new Coordenada(-74.116976, 4.67445),
                new Coordenada(-74.116838, 4.674284),
                new Coordenada(-74.115188, 4.671793),
                new Coordenada(-74.11414, 4.670135),
                new Coordenada(-74.11385, 4.669652),
                new Coordenada(-74.112831, 4.668098),
                new Coordenada(-74.112175, 4.667136),
                new Coordenada(-74.111364, 4.66586),
                new Coordenada(-74.111079, 4.665436),
                new Coordenada(-74.110544, 4.664568),
                new Coordenada(-74.109899, 4.663593),
                new Coordenada(-74.109683, 4.663237),
                new Coordenada(-74.109427, 4.662764),
                new Coordenada(-74.109003, 4.66208),
                new Coordenada(-74.108525, 4.66135),
                new Coordenada(-74.108391, 4.661116),
                new Coordenada(-74.108131, 4.660593),
                new Coordenada(-74.107903, 4.660249),
                new Coordenada(-74.107533, 4.659783),
                new Coordenada(-74.106903, 4.658813),
                new Coordenada(-74.106769, 4.658527),
                new Coordenada(-74.106531, 4.657828),
                new Coordenada(-74.105335, 4.655936),
                new Coordenada(-74.103799, 4.653561),
                new Coordenada(-74.103234, 4.652644),
                new Coordenada(-74.10267, 4.651803),
                new Coordenada(-74.100557, 4.648513),
                new Coordenada(-74.100383, 4.648328),
                new Coordenada(-74.100013, 4.647994),
                new Coordenada(-74.099601, 4.647473),
                new Coordenada(-74.099336, 4.647603),
                new Coordenada(-74.100178, 4.648845),
                new Coordenada(-74.100581, 4.649464),
                new Coordenada(-74.102308, 4.652188),
                new Coordenada(-74.105986, 4.657911),
                new Coordenada(-74.107216, 4.65988),
                new Coordenada(-74.108156, 4.661301),
                new Coordenada(-74.10895, 4.662556),
                new Coordenada(-74.109453, 4.663391),
                new Coordenada(-74.110279, 4.664579),
                new Coordenada(-74.112347, 4.667813),
                new Coordenada(-74.112762, 4.668543),
                new Coordenada(-74.113301, 4.669391),
                new Coordenada(-74.114066, 4.670531),
                new Coordenada(-74.114477, 4.671199),
                new Coordenada(-74.114622, 4.67148),
                new Coordenada(-74.115561, 4.67293),
                new Coordenada(-74.115749, 4.673282),
                new Coordenada(-74.11595, 4.673597),
                new Coordenada(-74.116188, 4.674222),
                new Coordenada(-74.117568, 4.676391),
                new Coordenada(-74.119049, 4.67868),
                new Coordenada(-74.119472, 4.679461),
                new Coordenada(-74.11973, 4.680027),
                new Coordenada(-74.119895, 4.680329),
                new Coordenada(-74.120121, 4.680672),
                new Coordenada(-74.121518, 4.68261),
                new Coordenada(-74.121839, 4.682994),
                new Coordenada(-74.122006, 4.683149),
                new Coordenada(-74.122519, 4.683563),
                new Coordenada(-74.124239, 4.684919),
                new Coordenada(-74.124973, 4.685415),
                new Coordenada(-74.126325, 4.686445)
        );
        agregarEntrada("Centro5", coordenadasCuartoTramo);
    }
}