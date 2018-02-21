package fr.nigui.trackmywallet.data;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import fr.nigui.trackmywallet.data.local.dao.ExchangePriceDao;
import fr.nigui.trackmywallet.data.local.dao.WalletDao;
import fr.nigui.trackmywallet.data.local.entity.Wallet;
import fr.nigui.trackmywallet.data.model.CryptoCurrency;
import fr.nigui.trackmywallet.data.model.Currency;
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
        refreshExchangePrice(CryptoCurrency.ETH, FiatCurrency.EUR);
        return walletDao.getWallet(walletID);
    }

    private void refreshWalletBalance(final String walletID) {
        ethereumWalletBalanceWebService.getWalletBalance(walletID)
                .doOnSuccess(response -> {
                    walletDao.saveWallet(new Wallet(walletID, response.getResult(), null));
                })
                .doOnError(error -> {
                    //TODO manage error
                    Log.e(getClass().getSimpleName(), error.getMessage());
                })
                .subscribeOn(Schedulers.single())
                .subscribe();
    }

    private void refreshExchangePrice(final CryptoCurrency crypto, final Currency targetCurrency) {

        exchangePriceWebService.fetchExchangePrice(crypto, targetCurrency)
                .doOnSuccess(price -> {

                    StringBuilder sb = new StringBuilder();

                    for (Map.Entry<Currency, String> e : price.getDestCurrencies().entrySet()) {
                        sb.append("\n\t--> " + e.getKey() + " : " + e.getValue());
                    }

                    Log.d(getClass().getSimpleName(), price.getSourceCurrency()
                            + sb.toString());
                })
                .doOnError(error -> {
                    //TODO manage error
                    Log.e(getClass().getSimpleName(), error.getMessage());
                })
                .subscribeOn(Schedulers.single())
                .subscribe();

    }


}
