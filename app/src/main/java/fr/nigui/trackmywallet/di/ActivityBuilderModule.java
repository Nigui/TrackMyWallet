package fr.nigui.trackmywallet.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import fr.nigui.trackmywallet.ui.WalletActivity;


@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract WalletActivity walletActivity();
}
