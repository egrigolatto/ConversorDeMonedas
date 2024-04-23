import com.google.gson.Gson; // clase Gson para manejar JSON
import java.io.IOException; //  IOException para manejar errores de entrada/salida
import java.net.URI; //  URI para manejar URLs
import java.net.http.HttpClient; //  HttpClient para realizar solicitudes HTTP
import java.net.http.HttpRequest; // HttpRequest para construir solicitudes HTTP
import java.net.http.HttpResponse; // HttpResponse para manejar respuestas HTTP

public class ConversorMoneda {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/933263214e95c8abcf83b1da/latest/";

    // Método para convertir monedas
    public double convertirMoneda(double monto, String monedaOrigen, String monedaDestino) {
        // Construimos la URL para la consulta a la API utilizando la moneda de origen
        String url = API_URL + monedaOrigen;
        try {
            // Creamos un cliente HTTP
            HttpClient client = HttpClient.newHttpClient();
            // Construimos una solicitud HTTP GET con la URL
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            // Envíamos la solicitud HTTP para obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Verificamos si la respuesta es exitosa
            if (response.statusCode() == 200) {
                // Obtenemos el cuerpo de la respuesta
                String responseBody = response.body();
                // Creamos un objeto Gson para parsear el JSON
                Gson gson = new Gson();
                // Convertimos el JSON en un objeto TipoCambio
                TipoCambio tipoCambio = gson.fromJson(responseBody, TipoCambio.class);
                // Obtenemos la tasa de cambio para la moneda destino
                Double tasa = tipoCambio.conversionRates.get(monedaDestino);
                // Verificamos si la tasa de cambio está disponible
                if (tasa == null) {
                    throw new RuntimeException("La tasa de cambio para la moneda destino no está disponible.");
                }
                // Calculamos y retornamos el monto convertido
                return monto * tasa;
            } else {
                // Si la respuesta no es exitosa, lanzamos una IOException con el código de estado
                throw new IOException("Error al consultar la API: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            // Capturamos y relanzamos cualquier excepción como una RuntimeException
            throw new RuntimeException("Error al conectar con la API: " + e.getMessage());
        }
    }
}


