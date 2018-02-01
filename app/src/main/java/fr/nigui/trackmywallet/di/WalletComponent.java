package fr.nigui.trackmywallet.di;

import javax.inject.Singleton;

import dagger.Component;
import fr.nigui.trackmywallet.WalletRepository;
import fr.nigui.trackmywallet.WalletViewModel;

/**
 * Created by g-lap on 01/02/2018.
 */

@Singleton
@Component(modules = {WalletModule.class})
public interface WalletComponent {

    void inject(WalletViewModel walletViewModel);

    void inject(WalletRepository walletRepository);

}
