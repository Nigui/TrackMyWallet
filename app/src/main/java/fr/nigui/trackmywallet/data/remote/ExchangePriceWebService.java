package fr.nigui.trackmywallet.data.remote;

import fr.nigui.trackmywallet.data.model.CryptoCurrency;
import fr.nigui.trackmywallet.data.model.Currency;
import fr.nigui.trackmywallet.data.remote.model.ExchangePriceApiResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by g-lap on 07/02/2018.
 */

public interface ExchangePriceWebService {

    @GET("{cryptocurrency}/")
    Single<ExchangePriceApiResponse> fetchExchangePrice(
            @Path("cryptocurrency") CryptoCurrency cryptocurrency,
            @Query("convert") Currency targetCurrency);

}
