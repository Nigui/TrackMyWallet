package fr.nigui.trackmywallet.data.model;

import android.arch.persistence.room.TypeConverter;

/**
 * Created by g-lap on 07/02/2018.
 */

public enum FiatCurrency {

    AUD("AUD"),     BRL("BRL"),     CAD("CAD"),     CHF("CHF"),
    CLP("CLP"),     CNY("CNY"),     CZK("CZK"),     DKK("DKK"),
    EUR("EUR"),     GBP("GBP"),     HKD("HKD"),     HUF("HUF"),
    IDR("IDR"),     ILS("ILS"),     INR("INR"),     JPY("JPY"),
    KRW("KRW"),     MXN("MXN"),     MYR("MYR"),     NOK("NOK"),
    NZD("NZD"),     PHP("PHP"),     PKR("PKR"),     PLN("PLN"),
    RUB("RUB"),     SEK("SEK"),     SGD("SGD"),     THB("THB"),
    TRY("TRY"),     TWD("TWD"),     ZAR("ZAR");

    String value;

    FiatCurrency(String value) {
        this.value = value;
    }

    /**
     * Convert FiatCurrency string to FiatCurrency enum.
     * @param fiat FiatCurrency string value
     * @return FiatCurrency string from which to get FiatCurrency instance.
     * @throws IllegalArgumentException if given string doesn't match any FiatCurrency constant
     */
    @TypeConverter
    public static FiatCurrency fromString(String fiat) {

        FiatCurrency[] constants = FiatCurrency.class.getEnumConstants();
        for( FiatCurrency constant : constants ){
            if( constant.value.compareTo(fiat) == 0 ){
                return constant;
            }
        }
        throw new IllegalArgumentException(
                "CryptoCurrency.fromString("+fiat+") - "+fiat+" doesn't exist"
        );
    }

    @TypeConverter
    public static String toString(FiatCurrency fiat){
        return fiat.name();
    }
}
