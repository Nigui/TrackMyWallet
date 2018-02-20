package fr.nigui.trackmywallet.data.model.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import fr.nigui.trackmywallet.data.model.CryptoCurrency;

/**
 * Created by g-lap on 12/02/2018.
 */

public class CryptoCurrencySerializer implements JsonSerializer<CryptoCurrency> {

    private static CryptoCurrencySerializer INSTANCE;

    private CryptoCurrencySerializer(){}

    public static CryptoCurrencySerializer getInstance(){
        if( INSTANCE == null ){
            INSTANCE = new CryptoCurrencySerializer();
        }
        return INSTANCE;
    }

    @Override
    public JsonElement serialize(CryptoCurrency src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(CryptoCurrency.toString(src));
    }
}
