import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record Moneda(String base_code, Map<String, Double> conversion_rates) {
}
