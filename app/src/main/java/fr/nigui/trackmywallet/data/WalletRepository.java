package fr.nigui.trackmywallet.data;

import android.arch.lifecycle.LiveData;
import android.util.Log;
import android.webkit.JavascriptInterface;

import javax.inject.Inject;
import javax.inject.Singleton;

import fr.nigui.trackmywallet.data.local.dao.ExchangePriceDao;
import fr.nigui.trackmywallet.data.local.entity.ExchangePrice;
import fr.nigui.trackmywallet.data.local.entity.Wallet;
import fr.nigui.trackmywallet.data.local.dao.WalletDao;
import fr.nigui.trackmywallet.data.model.CryptoCurrency;
import fr.nigui.trackmywallet.data.model.FiatCurrency;
import fr.nigui.trackmywallet.data.remote.EthereumWalletBalanceWebService;
import fr.nigui.trackmywallet.data.remote.ExchangePriceWebService;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by g-lap on 27/01/2018.
 */
@Singleton
public class WalletRepository {

    private final WalletDao walletDao;
    private final EthereumWalletBalanceWebService ethereumWalletBalanceWebService;

    private final ExchangePriceDao exchangePriceDao;
    private final ExchangePriceWebService exchangePriceWebService;

    @Inject
    public WalletRepository(
            WalletDao walletDao,
            ExchangePriceDao exchangePriceDao,
            ExchangePriceWebService exchangePriceWebService,
            EthereumWalletBalanceWebService ethereumWalletBalanceWebService) {
        this.walletDao = walletDao;
        this.exchangePriceDao = exchangePriceDao;
        this.exchangePriceWebService = exchangePriceWebService;
        this.ethereumWalletBalanceWebService = ethereumWalletBalanceWebService;
    }

    public LiveData<Wallet> getWallet(String walletID) {
        refreshWalletBalance(walletID);
        refreshExchangePrice(FiatCurrency.EUR,CryptoCurrency.ETH);
        return walletDao.getWallet(walletID);
    }

    private void refreshWalletBalance(final String walletID){
        ethereumWalletBalanceWebService.getWalletBalance(walletID)
            .doOnSuccess(response -> {
                walletDao.saveWallet(new Wallet(walletID,response.getResult(),null));
            })
            .doOnError(error -> {
                //TODO manage error
                Log.e(getClass().getSimpleName(),error.getMessage());
            })
            .subscribeOn(Schedulers.single())
            .subscribe();
    }

    private void refreshExchangePrice(final FiatCurrency fiat, final CryptoCurrency crypto){

        exchangePriceWebService.fetchExchangePrice(crypto,fiat)
                .doOnSuccess(price -> {
                    Log.d(getClass().getSimpleName(),"price : "+price);
                })
                .doOnError(error -> {
                    //TODO manage error
                    Log.e(getClass().getSimpleName(),error.getMessage());
                })
                .subscribeOn(Schedulers.single())
                .subscribe();

    }




}
