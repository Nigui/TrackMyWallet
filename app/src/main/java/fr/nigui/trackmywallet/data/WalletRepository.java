package fr.nigui.trackmywallet.data;

import android.arch.lifecycle.LiveData;

import javax.inject.Inject;
import javax.inject.Singleton;

import fr.nigui.trackmywallet.data.local.entity.Wallet;
import fr.nigui.trackmywallet.data.local.dao.WalletDao;
import fr.nigui.trackmywallet.data.remote.WalletWebService;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by g-lap on 27/01/2018.
 */
@Singleton
public class WalletRepository {

    private final WalletDao walletDao;
    private final WalletWebService walletWebService;

    @Inject
    public WalletRepository(WalletDao walletDao,WalletWebService walletWebService) {
        this.walletDao = walletDao;
        this.walletWebService = walletWebService;
    }

    public LiveData<Wallet> getWallet(String walletID) {
        refreshWallet(walletID);
        return walletDao.getWallet(walletID);
    }

    private void refreshWallet(final String walletID){
        walletWebService.getWalletBalance(walletID)
            .doOnSuccess(response -> {
                walletDao.saveWallet(new Wallet(walletID,response.getResult(),null));
            })
            .doOnError(error -> {
                //TODO manage error
                System.out.println(error.getMessage());
            })
            .subscribeOn(Schedulers.single())
            .subscribe();
    }

}
