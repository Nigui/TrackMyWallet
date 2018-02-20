package fr.nigui.trackmywallet.data.remote.factory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.annotation.Nullable;

import fr.nigui.trackmywallet.data.local.entity.ExchangePrice;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by g-lap on 10/02/2018.
 */

public class ExchangePriceFactory extends Converter.Factory {


    public static ExchangePriceFactory create(){
        return new ExchangePriceFactory();
    }


    @Nullable
    @Override
    public Converter<ResponseBody, ExchangePriceFactory> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {

        if( type == ExchangePrice.class ){
        }

        return null;
    }

    @Nullable
    @Override
    public Converter<ExchangePriceFactory, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {


        return null;
    }
}
