import com.google.gson.annotations.SerializedName; // anotacion SerializedName de la biblioteca Gson
import java.util.HashMap; // clase HashMap para usar en la definicion de conversionRates

public class TipoCambio {
    @SerializedName("result") // el campo "result" del JSON se mapeará a esta variable
    String result; // Variable para almacenar el resultado de la consulta a la API

    @SerializedName("conversion_rates") // el campo "conversion_rates" del JSON se mapeará a esta variable
    HashMap<String, Double> conversionRates; // HashMap para almacenar las tasas de cambio entre monedas
}

