package fr.nigui.trackmywallet.data.remote.model.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.annotation.Nullable;

import fr.nigui.trackmywallet.data.model.CryptoCurrency;
import fr.nigui.trackmywallet.data.model.Currency;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by g-lap on 21/02/2018.
 */

public class CurrencyConverterFactory extends Converter.Factory {

    private CurrencyConverterFactory() {
    }

    public static CurrencyConverterFactory create() {
        return new CurrencyConverterFactory();
    }

    @Nullable
    @Override
    public Converter<? extends Currency, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {

        if (annotations.length > 0) {

            // any Currency object (or sub-class) annotated with Query
            if (annotations[0].annotationType() == Query.class) {
                return (Converter<Currency, String>) Currency::getSymbol;
            }

            // CryptoCurrency objects annotated with Path
            if (type instanceof Class
                    && CryptoCurrency.class.isAssignableFrom((Class) type)
                    && annotations[0].annotationType() == Path.class) {
                return (Converter<Currency, String>) Currency::getName;
            }

        }

        return null;

    }
}
