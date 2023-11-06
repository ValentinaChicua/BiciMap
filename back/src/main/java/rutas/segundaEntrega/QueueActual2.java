package rutas.segundaEntrega;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URLEncoder;

public class QueueActual2 {
    NodoActual2 head, rear;
    int size;

    public QueueActual2() {
        head = rear = null;
        size = 0;
    }

    public boolean Empty() {
        return head == null;
    }
    HttpClient httpClient = HttpClients.createDefault();
    public void Push(String address1, String address2) throws Exception {
        String coordinates1 = getCoordinates(httpClient, address1);
        // Obtener coordenadas de la segunda dirección
        String coordinates2 = getCoordinates(httpClient, address2);

        if (coordinates1 != null && coordinates2 != null) {
            // Parsear las coordenadas
            String[] parts1 = coordinates1.split(",");
            String lat1 = parts1[0];
            String lon1 = parts1[1];

            String[] parts2 = coordinates2.split(",");
            String lat2 = parts2[0];
            String lon2 = parts2[1];

            // Calcular la distancia entre las coordenadas
            double distance = haversineDistance(Double.parseDouble(lat1), Double.parseDouble(lon1),
                    Double.parseDouble(lat2), Double.parseDouble(lon2));
            NodoActual2 nuevo = new NodoActual2(address1,address2,lat1,lon1,lat2,lon2,distance);
            if (Empty()){
                head =nuevo;
            }else{
                rear.next = nuevo;
            }

            System.out.println("La distancia entre las dos direcciones es " + distance + " kilómetros.");
        } else {
            System.out.println("No se pudieron obtener las coordenadas de una o ambas direcciones.");
        }
    }
    public static String getCoordinates(HttpClient httpClient, String address) throws Exception {
        String encodedAddress = URLEncoder.encode(address, "UTF-8");
        String url = "https://nominatim.openstreetmap.org/search?format=json&q=" + encodedAddress;
        HttpGet request = new HttpGet(url);
        org.apache.http.HttpResponse response = httpClient.execute(request);
        String jsonResponse = EntityUtils.toString(response.getEntity());
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(jsonResponse).getAsJsonArray();

        if (jsonArray.size() > 0) {
            JsonObject firstResult = jsonArray.get(0).getAsJsonObject();
            String lat = firstResult.get("lat").getAsString();
            String lon = firstResult.get("lon").getAsString();
            return lat + "," + lon;
        } else {
            return null;
        }
    }
    public static double haversineDistance(double lat1, double lon1, double lat2, double lon2) {
        // Radio de la Tierra en kilómetros
        double R = 6371.0;

        // Convertir las latitudes y longitudes de grados a radianes
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        // Diferencia entre las latitudes y longitudes
        double dlat = lat2 - lat1;
        double dlon = lon2 - lon1;

        // Calcular la fórmula del haversine
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
    public void Pop() {
        try {
            Object aux1 = head.iniDireccion;
            Object aux2 = head.finDireccion;
            Object aux3 = head.km;
            head = head.next;
            size--;
            System.out.println("Se ejecutó la ruta con inicio en: " + aux1 + " y fin en: " + aux2 + ", esta ruta consta de " + aux3 + " km.");
        } catch (Exception e) {
            System.out.println("Aun no hay rutas a ejecutar, por favor ingrese una");
        }
    }

    public void Head() {
        Object aux1 = head.iniDireccion;
        Object aux2 = head.finDireccion;
        Object aux3 = head.km;
        System.out.println("La siguiente ruta a ejecutar tiene inicio en: " + aux1 + " y fin en: " + aux2 + " y consta de " + aux3 + " km.");
    }

    public Object Size() {
        return size;
    }
    public void mostrarRutas() {
        NodoActual2 current = head;

        if (current == null) {
            System.out.println("No hay rutas en la cola.");
            return;
        }

        System.out.println("Rutas en la cola:");
        int numeroRuta = 1;

        while (current != null) {
            System.out.println("Ruta " + numeroRuta + ":");
            System.out.println("Inicio: " + current.iniDireccion);
            System.out.println("Fin: " + current.finDireccion);
            System.out.println("Longitud de la Ruta: " + (double) Math.round(current.km * 100d) / 100 + " km");
            System.out.println();

            current = current.next;
            numeroRuta++;
        }
    }
}


