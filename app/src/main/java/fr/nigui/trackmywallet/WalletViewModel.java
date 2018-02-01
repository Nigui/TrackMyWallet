package fr.nigui.trackmywallet;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import fr.nigui.trackmywallet.di.DaggerWalletComponent;

/**
 * Created by g-lap on 25/01/2018.
 */

public class WalletViewModel extends ViewModel {

    private LiveData<Wallet> wallet;

    @Inject
    WalletRepository walletRepo;

    public WalletViewModel() {
        DaggerWalletComponent.create().inject(this);
    }

    public void init(String walletID){
        if( this.wallet != null ){
            return;
        }
        this.wallet = this.walletRepo.getWallet(walletID);
    }

    public LiveData<Wallet> getWallet() {
        return wallet;
    }
}
