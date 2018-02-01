package fr.nigui.trackmywallet;

import android.arch.lifecycle.LiveData;

import javax.inject.Inject;
import javax.inject.Singleton;

import fr.nigui.trackmywallet.di.DaggerWalletComponent;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by g-lap on 27/01/2018.
 */
@Singleton
public class WalletRepository {

    @Inject
    WalletWebService walletWebService;

    WalletDao walletDao;

    public WalletRepository() {
        DaggerWalletComponent.create().inject(this);
    }

    public LiveData<Wallet> getWallet(String walletID) {
        refreshWallet(walletID);
        return walletDao.load(walletID);
    }

    private void refreshWallet(final String walletID){
        walletWebService.getWallet(walletID)
            .doOnSuccess(walletDao::save)
            .doOnError(error -> {
                //TODO manage error
                System.out.println(error.getMessage());
            })
            .subscribeOn(Schedulers.single())
            .subscribe();
    }

}
