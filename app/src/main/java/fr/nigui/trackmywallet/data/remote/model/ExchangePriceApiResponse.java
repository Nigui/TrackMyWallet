package fr.nigui.trackmywallet.data.remote.model;

import java.util.Map;

import fr.nigui.trackmywallet.data.model.Currency;

/**
 * Created by g-lap on 10/02/2018.
 */

public class ExchangePriceApiResponse {

    Currency sourceCurrency;
    Map<Currency, String> destCurrencies;

    public ExchangePriceApiResponse(Currency sourceCurrency, Map<Currency, String> destCurrencies) {
        this.sourceCurrency = sourceCurrency;
        this.destCurrencies = destCurrencies;
    }

    public Currency getSourceCurrency() {
        return sourceCurrency;
    }

    public Map<Currency, String> getDestCurrencies() {
        return destCurrencies;
    }
}
