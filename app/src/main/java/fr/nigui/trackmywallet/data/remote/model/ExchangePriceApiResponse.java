package fr.nigui.trackmywallet.data.remote.model;

import java.util.Map;

import fr.nigui.trackmywallet.data.model.CryptoCurrency;
import fr.nigui.trackmywallet.data.model.FiatCurrency;

/**
 * Created by g-lap on 10/02/2018.
 */

public class ExchangePriceApiResponse {

    CryptoCurrency sourceCurrency;
    Map<FiatCurrency,String> destCurrencies;

    public ExchangePriceApiResponse(CryptoCurrency sourceCurrency, Map<FiatCurrency, String> destCurrencies) {
        this.sourceCurrency = sourceCurrency;
        this.destCurrencies = destCurrencies;
    }

    public CryptoCurrency getSourceCurrency() {
        return sourceCurrency;
    }

    public Map<FiatCurrency, String> getDestCurrencies() {
        return destCurrencies;
    }
}
