package fr.nigui.trackmywallet.data.model;

import android.arch.persistence.room.TypeConverter;

/**
 * Created by g-lap on 08/02/2018.
 */

public enum CryptoCurrency {

    ETH("ethereum"),     BTC("bitcoin"),     XRP("XRP"),     BCH("BCH"),
    QTUM("QTUM");

    String value;

    CryptoCurrency(String value) {
        this.value = value;
    }

    /**
     * Convert cryptocurrency string to CryptoCurrency enum.
     * @param crypto cryptocurrency string value
     * @return cryptocurrency string from which to get CryptoCurrency instance.
     * @throws IllegalArgumentException if given string doesn't match any references CryptoCurrency
     */
    @TypeConverter
    public static CryptoCurrency fromString(String crypto) throws IllegalArgumentException{
        CryptoCurrency[] constants = CryptoCurrency.class.getEnumConstants();
        for( CryptoCurrency constant : constants ){
            if( constant.value.compareTo(crypto) == 0 ){
                return constant;
            }
        }
        throw new IllegalArgumentException(
                "CryptoCurrency.fromString("+crypto+") - "+crypto+" doesn't exist");
    }

    /**
     * Converts given CryptoCurrency to its string value.
     * Used by Room for the database
     */
    @TypeConverter
    public static String toString(CryptoCurrency crypto){
        return crypto.value;
    }



}
