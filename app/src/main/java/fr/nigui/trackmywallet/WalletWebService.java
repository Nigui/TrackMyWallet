package fr.nigui.trackmywallet;


import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by g-lap on 27/01/2018.
 */

public interface WalletWebService {

    @GET("/api?" +
            "module=account" +
            "&action=balance" +
            "&tag=latest" +
            "&apikey="+BuildConfig.ETHERSCAN_API_KEY)
    Single<Wallet> getWallet(@Query("address") String walletAddress);
}