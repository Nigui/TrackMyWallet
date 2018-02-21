package fr.nigui.trackmywallet.data.remote.model.serializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Map;

import fr.nigui.trackmywallet.data.model.Currency;
import fr.nigui.trackmywallet.data.remote.model.ExchangePriceApiResponse;
import fr.nigui.trackmywallet.util.model.CurrencyUtils;
import io.reactivex.Observable;

/**
 * Created by g-lap on 20/02/2018.
 */

public class ExchangePriceApiResponseSerializer implements JsonDeserializer<ExchangePriceApiResponse> {

    private static ExchangePriceApiResponseSerializer INSTANCE;

    private ExchangePriceApiResponseSerializer() {
    }

    public static ExchangePriceApiResponseSerializer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ExchangePriceApiResponseSerializer();
        }
        return INSTANCE;
    }

    @Override
    public ExchangePriceApiResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonArray array = json.getAsJsonArray();
        if (array != null && array.size() > 0) {
            JsonObject firstItemObject = array.get(0).getAsJsonObject();

            /*
            * For each price_* json property,
            * Extract into Map currency enum constant and exchange price
            */
            Map<Currency, String> exchangePrices =
                    Observable.fromIterable(() -> firstItemObject.entrySet().iterator())
                            .filter(jsonProperty -> jsonProperty.getKey().startsWith("price_"))
                            .map(jsonProperty -> {
                                String currencyKey = jsonProperty.getKey()
                                        .replace("price_", "")
                                        .toUpperCase();
                                String exchangePrice = jsonProperty.getValue().getAsString();
                                Currency currency = CurrencyUtils.fromString(currencyKey);
                                return new AbstractMap.SimpleEntry<>(currency, exchangePrice);
                            })
                            .toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)
                            .blockingGet();

            String sourceCurrency = firstItemObject.get("symbol").getAsString();

            return new ExchangePriceApiResponse(CurrencyUtils.fromString(sourceCurrency), exchangePrices);
        }

        throw new RuntimeException("json array from exchange webservice is empty or null ");
    }
}
