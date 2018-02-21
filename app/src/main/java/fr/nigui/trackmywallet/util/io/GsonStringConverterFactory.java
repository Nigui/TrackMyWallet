package fr.nigui.trackmywallet.util.io;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * A Gson Factory for String Converters.
 * It searches into given Gson type adapters ((de)serializers) to convert types used by a retrofit
 * query into a string forming final url.
 * It prevents overriding default type toString method.
 * @See <a href="https://stackoverflow.com/a/42459356">Solution found on StackOverflow</a>
 */
public class GsonStringConverterFactory extends Converter.Factory {

    private final Gson gson;

    private GsonStringConverterFactory(final Gson gson) {
        this.gson = gson;
    }

    public static GsonStringConverterFactory create(final Gson gson){
        if (gson == null) throw new NullPointerException("gson == null");
        return new GsonStringConverterFactory(gson);
    }


    @Override
    public Converter<?, String> stringConverter(final Type type, final Annotation[] annotations, final Retrofit retrofit) {

        final TypeAdapter typeAdapter;
        typeAdapter = gson.getAdapter(TypeToken.get(type));

        return new StringConverter<>(typeAdapter,type,annotations,retrofit);
    }

    private static class StringConverter<T>
            implements Converter<T, String> {

        private final TypeAdapter<T> typeAdapter;
        Type type;
        Annotation[] annotation;
        Retrofit retrofit;

        private StringConverter(TypeAdapter<T> typeAdapter, Type type, Annotation[] annotation, Retrofit retrofit) {
            this.typeAdapter = typeAdapter;
            this.type = type;
            this.annotation = annotation;
            this.retrofit = retrofit;
        }

        @Override
        public String convert(final T value) throws IOException {
            final String jsonValue;
            jsonValue = typeAdapter.toJson(value);

            if (jsonValue.startsWith("\"") && jsonValue.endsWith("\"") ){
                /* Strip enclosing quotes for json String types */
                return jsonValue.substring(1, jsonValue.length() - 1);
            } else {
                return jsonValue;
            }
        }
    }
}
