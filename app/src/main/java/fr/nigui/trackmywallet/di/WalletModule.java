package fr.nigui.trackmywallet.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.nigui.trackmywallet.WalletRepository;
import fr.nigui.trackmywallet.WalletWebService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by g-lap on 01/02/2018.
 */

@Module
public class WalletModule {

    @Provides
    @Singleton
    public WalletRepository provideWalletRepository(){
        return new WalletRepository();
    }


    @Provides
    @Singleton
    public WalletWebService provideWalletWebService() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.etherscan.io")
                .build()
                .create(WalletWebService.class);
    }
}
