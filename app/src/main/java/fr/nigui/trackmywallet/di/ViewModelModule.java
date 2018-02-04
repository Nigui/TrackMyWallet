package fr.nigui.trackmywallet.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import fr.nigui.trackmywallet.ui.WalletViewModel;
import fr.nigui.trackmywallet.viewmodel.WalletViewModelFactory;

/**
 * Created by mertsimsek on 19/06/2017.
 */

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WalletViewModel.class)
    abstract ViewModel bindsWalletViewModel(WalletViewModel walletViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(WalletViewModelFactory walletViewModelFactory);
}
