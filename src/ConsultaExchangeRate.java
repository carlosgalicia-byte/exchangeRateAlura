import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultaExchangeRate {
    public double consultaMoneda (String monedaAbreviada, String monedaAConvertir, double cantidadAConvertir){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f2dd9cd04a2a1784060feb0a/latest/" + monedaAbreviada + "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Moneda moneda = new Gson().fromJson(response.body(), Moneda.class);
            Map<String, Double> rates = moneda.conversion_rates();
            //Operacion de conversion
            return cantidadAConvertir * rates.get(monedaAConvertir);
        } catch (Exception e) {
            throw new RuntimeException("Algo salio mal!");
        }

    }
}
