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
    TRY("TRY"),     TWD("TWD"),     USD("USD"),     ZAR("ZAR");

    String symbol;

    FiatCurrency(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Convert FiatCurrency string to FiatCurrency enum.
     * @param fiat FiatCurrency string name
     * @return FiatCurrency constant related to given fiat name or symbol. Null if not supported
     */
    @TypeConverter
    public static FiatCurrency fromString(String fiat) {
        if( fiat != null ) {
            FiatCurrency[] constants = FiatCurrency.class.getEnumConstants();
            for (FiatCurrency constant : constants) {
                if (constant.symbol.compareTo(fiat) == 0) {
                    return constant;
                }
            }
        }
        return null;
    }

    @TypeConverter
    public static String toString(FiatCurrency fiat){
        return fiat.symbol;
    }
}
