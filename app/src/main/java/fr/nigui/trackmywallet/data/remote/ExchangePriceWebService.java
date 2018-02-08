package fr.nigui.trackmywallet.data.remote;

import fr.nigui.trackmywallet.data.model.FiatCurrency;
import fr.nigui.trackmywallet.data.remote.model.WalletBalanceApiResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by g-lap on 07/02/2018.
 */

public interface ExchangePriceWebService {

    @GET("{cryptocurrency}/")
    Single<WalletBalanceApiResponse> getWalletBalance(
            @Path("cryptocurrency") String cryptocurrency,
            @Query("convert") FiatCurrency fiatCurrency);

}
