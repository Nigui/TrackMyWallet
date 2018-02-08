package fr.nigui.trackmywallet.data.converters;

import android.arch.persistence.room.TypeConverter;

import fr.nigui.trackmywallet.data.model.CryptoCurrency;

/**
 * Created by g-lap on 08/02/2018.
 */

public class CryptoCurrencyConverters {

    @TypeConverter
    public static CryptoCurrency fromString(String crypto){
        return CryptoCurrency.fromString(crypto);
    }

    @TypeConverter
    public static String toString(CryptoCurrency crypto){
        return crypto.name();
    }

}
