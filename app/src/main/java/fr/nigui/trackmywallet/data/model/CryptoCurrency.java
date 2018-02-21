package fr.nigui.trackmywallet.data.model;

import android.arch.persistence.room.TypeConverter;

/**
 * Created by g-lap on 08/02/2018.
 */

public enum CryptoCurrency implements Currency {

    ETH("ethereum", "ETH"),
    BTC("bitcoin", "BTC");

    private final String name;
    private final String symbol;

    CryptoCurrency(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * Convert cryptocurrency string to CryptoCurrency enum.
     * Can convert from name or symbol.
     *
     * @param crypto cryptocurrency string name or symbol
     * @return cryptocurrency string from which to get CryptoCurrency instance.
     */
    @TypeConverter
    public static CryptoCurrency fromString(String crypto) throws IllegalArgumentException {
        CryptoCurrency[] constants = CryptoCurrency.class.getEnumConstants();
        for (CryptoCurrency constant : constants) {
            if (constant.name.compareTo(crypto) == 0
                    || constant.symbol.compareTo(crypto) == 0) {
                return constant;
            }
        }
        return null;
    }

    /**
     * Converts given CryptoCurrency to its string name.
     * Used by Room for the database
     */
    @TypeConverter
    public static String toString(CryptoCurrency crypto) {
        return crypto.name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }


}
