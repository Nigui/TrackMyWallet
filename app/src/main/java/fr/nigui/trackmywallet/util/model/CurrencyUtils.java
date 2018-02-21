package fr.nigui.trackmywallet.util.model;

import fr.nigui.trackmywallet.data.model.CryptoCurrency;
import fr.nigui.trackmywallet.data.model.Currency;
import fr.nigui.trackmywallet.data.model.FiatCurrency;

/**
 * Created by g-lap on 21/02/2018.
 */

public abstract class CurrencyUtils {


    public static final Currency fromString(String string){

        Currency ret;
        ret = CryptoCurrency.fromString(string);
        if( ret == null ){
            ret = FiatCurrency.fromString(string);
        }

        return ret;


    }

}
