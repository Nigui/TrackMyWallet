package fr.nigui.trackmywallet.data.model;

import android.arch.persistence.room.TypeConverter;

/**
 * Created by g-lap on 07/02/2018.
 */

public enum FiatCurrency implements Currency{

    AUD("australia_dollar","AUD"),
    BRL("brazilian_real","BRL"),
    CAD("canadian_dollar","CAD"),
    CHF("swiss_franc","CHF"),
    CLP("chilean_peso","CLP"),
    CNY("renminbi_yuan","CNY"),
    CZK("czech_koruna","CZK"),
    DKK("danish_krone","DKK"),
    EUR("euro","EUR"),
    GBP("pound_sterling","GBP"),
    HKD("hong_kong_dollar","HKD"),
    HUF("hungarian_forint","HUF"),
    IDR("indonesian_rupiah","IDR"),
    ILS("israeli_new_shekel","ILS"),
    INR("indian_rupee","INR"),
    JPY("japanese_yen","JPY"),
    KRW("south_korean_won","KRW"),
    MXN("mexican_peso","MXN"),
    MYR("malaysian_ringgit","MYR"),
    NOK("norwegian_krone","NOK"),
    NZD("new_zealand_dollar","NZD"),
    PHP("philippine_piso","PHP"),
    PKR("pakistan_rupee","PKR"),
    PLN("polish_zloty","PLN"),
    RUB("russian_ruble","RUB"),
    SEK("swedish_krona","SEK"),
    SGD("singapor_dollar","SGD"),
    THB("thai_baht","THB"),
    TRY("turkish_lira","TRY"),
    TWD("new_taiwan_dollar","TWD"),
    USD("united_states_dollar","USD"),
    ZAR("south_african_rand","ZAR");

    private final String name;
    private final String symbol;

    FiatCurrency(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @TypeConverter
    public static String toString(FiatCurrency fiat){
        return fiat.symbol;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
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
                if (constant.symbol.compareTo(fiat) == 0
                        || constant.name.compareTo(fiat) == 0 ) {
                    return constant;
                }
            }
        }
        return null;
    }

}
