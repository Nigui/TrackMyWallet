package fr.nigui.trackmywallet.data.local.entity;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import fr.nigui.trackmywallet.data.model.CryptoCurrency;
import fr.nigui.trackmywallet.data.model.FiatCurrency;

/**
 * Created by g-lap on 08/02/2018.
 */

@Entity(primaryKeys = {"fiat", "crypto"})
public class ExchangePrice {

    @NonNull
    private FiatCurrency fiat;
    @NonNull
    private CryptoCurrency crypto;
    private double price;

    public ExchangePrice(FiatCurrency fiat, CryptoCurrency crypto, double price) {
        this.fiat = fiat;
        this.crypto = crypto;
        this.price = price;
    }

    public FiatCurrency getFiat() {
        return fiat;
    }

    public CryptoCurrency getCrypto() {
        return crypto;
    }

    public double getPrice() {
        return price;
    }
}
