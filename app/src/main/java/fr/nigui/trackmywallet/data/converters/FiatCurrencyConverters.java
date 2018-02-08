package fr.nigui.trackmywallet.data.converters;

import android.arch.persistence.room.TypeConverter;

import fr.nigui.trackmywallet.data.model.FiatCurrency;

/**
 * Created by g-lap on 08/02/2018.
 */

public class FiatCurrencyConverters {

    @TypeConverter
    public static FiatCurrency fromString(String fiat){
        return FiatCurrency.fromString(fiat);
    }

    @TypeConverter
    public static String toString(FiatCurrency fiat){
        return fiat.name();
    }

}
