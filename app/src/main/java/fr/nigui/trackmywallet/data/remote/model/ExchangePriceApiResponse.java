package fr.nigui.trackmywallet.data.remote.model;

/**
 * Created by g-lap on 10/02/2018.
 */

public class ExchangePriceApiResponse {

    String price;

    public ExchangePriceApiResponse(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }
}
