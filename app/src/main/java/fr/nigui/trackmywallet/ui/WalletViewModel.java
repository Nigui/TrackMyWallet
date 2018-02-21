package fr.nigui.trackmywallet.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import fr.nigui.trackmywallet.data.WalletRepository;
import fr.nigui.trackmywallet.data.local.entity.Wallet;

/**
 * Created by g-lap on 25/01/2018.
 */

public class WalletViewModel extends ViewModel {

    private final WalletRepository walletRepo;
    private LiveData<Wallet> walletLiveData;

    @Inject
    public WalletViewModel(WalletRepository walletRepo) {
        this.walletRepo = walletRepo;
    }

    public LiveData<Wallet> getWallet(String walletID) {
        if (walletLiveData == null) {
            this.walletLiveData = walletRepo.getWallet(walletID);
        }
        return this.walletLiveData;
    }
}
