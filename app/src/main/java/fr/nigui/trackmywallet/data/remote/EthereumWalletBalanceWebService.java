package fr.nigui.trackmywallet.data.remote;


import fr.nigui.trackmywallet.BuildConfig;
import fr.nigui.trackmywallet.data.remote.model.WalletBalanceApiResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by g-lap on 27/01/2018.
 */

public interface EthereumWalletBalanceWebService {

    @GET("api?" +
            "module=account" + "&" +
            "action=balance" + "&" +
            "tag=latest" + "&" +
            "apikey="+ BuildConfig.ETHERSCAN_API_KEY)
    Single<WalletBalanceApiResponse> getWalletBalance(@Query("address") String walletAddress);
}