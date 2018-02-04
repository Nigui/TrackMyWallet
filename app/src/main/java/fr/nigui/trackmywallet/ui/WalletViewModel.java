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

    @Inject
    public WalletViewModel(WalletRepository walletRepo) {
        this.walletRepo = walletRepo;
    }

    public LiveData<Wallet> getWallet(String walletID) {
        return this.walletRepo.getWallet(walletID);
    }
}
