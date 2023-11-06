package rutas.primeraEntrega;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class Queue {
    Nodo head, rear;
    int size;
    public Queue (){
        head = rear = null;
        size=0;
    }
    public boolean Empty(){
        return head==null;
    }
    public String formatearDireccion(String direccion) {
        // Extraer el número de casa o edificio
        String[] partesDireccion = direccion.split("#");
        String numeroCasa = partesDireccion.length > 1 ? partesDireccion[1].trim() : "";

        // Extraer el nombre de la calle
        String nombreCalle = partesDireccion[0].trim();

        // Concatenar en el formato adecuado
        String direccionFormateada =  nombreCalle+ " "+numeroCasa  ;

        // Agregar "Bogotá, Colombia"
        //direccionFormateada += ", Bogotá, Colombia";

        return direccionFormateada;
    }
    public void Push(String iniDireccion, String finDireccion) {

        String direccionInicio = formatearDireccion(iniDireccion);
        String direccionFin = formatearDireccion(finDireccion);
        // Realiza la geocodificación inversa para obtener coordenadas de inicio y fin
        double[] inicioCoordenadas = geocode(direccionInicio);
        double[] finCoordenadas = geocode(direccionFin);

        if (inicioCoordenadas != null && finCoordenadas != null) {
            double distancia = calcularDistancia(inicioCoordenadas[0], inicioCoordenadas[1], finCoordenadas[0], finCoordenadas[1]);
            Nodo nuevo = new Nodo(iniDireccion,finDireccion,inicioCoordenadas[0], inicioCoordenadas[1], finCoordenadas[0], finCoordenadas[1], distancia);

            if (Empty()) {
                head = nuevo;
            } else {
                rear.next = nuevo;
            }

            rear = nuevo;
            size++;
        } else {
            System.out.println("No se pudieron obtener las coordenadas para las direcciones proporcionadas.");
        }
    }
    public void Pop(){
        try {
            Object aux1 = head.iniDireccion;
            Object aux2 = head.finDireccion;
            Object aux3 = head.km;
            head = head.next;
            size--;
            System.out.println("Se ejecutó la ruta con inicio en: "+aux1+" y fin en: "+aux2+", esta ruta consta de "+aux3+" km.");
        }catch (Exception e) {
            System.out.println("Aun no hay rutas a ejcutar, por favor ingrese una");
        }
    }
    public void Head(){
        Object aux1 = head.iniDireccion;
        Object aux2 = head.finDireccion;
        Object aux3 = head.km;
        System.out.println("La siguiente ruta a ejecutar tiene inicio en: "+aux1+" y fin en: "+aux2+"y consta de "+aux3+" km.");
    }
    public Object Size(){
        return size;
    }
    private double[] geocode(String address) {
        try {
            // Codifica la dirección antes de incluirla en la URL
            String encodedAddress = URLEncoder.encode(address, "UTF-8");

            String url = "https://nominatim.openstreetmap.org/search?format=json&q=" + encodedAddress;
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            String jsonResponse = response.toString();

            // Convierte la respuesta JSON a un array de objetos JSON
            JSONArray jsonArray = new JSONArray(jsonResponse);

            // Verifica si el array tiene elementos
            if (jsonArray.length() > 0) {
                // Obtiene el primer objeto JSON
                JSONObject firstResult = jsonArray.getJSONObject(0);

                // Extrae los valores de latitud y longitud
                double lat = firstResult.getDouble("lat");
                double lon = firstResult.getDouble("lon");

                return new double[]{lat, lon};
            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        final int RADIO_TIERRA = 6371; // Radio promedio de la Tierra en kilómetros

        double latitud1Rad = Math.toRadians(lat1);
        double latitud2Rad = Math.toRadians(lat2);

        double diferenciaLatitudRad = Math.toRadians(lat2 - lat1);
        double diferenciaLongitudRad = Math.toRadians(lon2 - lon1);

        double a = Math.sin(diferenciaLatitudRad / 2) * Math.sin(diferenciaLatitudRad / 2)
                + Math.cos(latitud1Rad) * Math.cos(latitud2Rad)
                * Math.sin(diferenciaLongitudRad / 2) * Math.sin(diferenciaLongitudRad / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RADIO_TIERRA * c; // Distancia en kilómetros
    }
    public void mostrarRutas() {
        Nodo current = head;

        if (current == null) {
            System.out.println("No hay rutas en la cola.");
            return;
        }

        System.out.println("Rutas en la cola:");
        int numeroRuta = 1;

        while (current != null) {
            System.out.println("Ruta " + numeroRuta + ":");
            System.out.println("Inicio: "+ current.iniDireccion);
            System.out.println("Fin: "+current.finDireccion);
            System.out.println("Longitud de la Ruta: " + (double) Math.round( current.km*100d) / 100+ " km");
            System.out.println();

            current = current.next;
            numeroRuta++;
        }
    }
}
