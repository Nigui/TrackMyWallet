package fr.nigui.trackmywallet.di;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.nigui.trackmywallet.data.local.TrackMyWalletDatabase;
import fr.nigui.trackmywallet.data.local.dao.WalletDao;
import fr.nigui.trackmywallet.data.remote.ApiConstants;
import fr.nigui.trackmywallet.data.remote.WalletWebService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by g-lap on 04/02/2018.
 */
@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    public Context provideContext(Application application){
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    public WalletWebService provideWalletWebService() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiConstants.ENDPOINT)
                .build()
                .create(WalletWebService.class);
    }

    @Provides
    @Singleton
    public TrackMyWalletDatabase provideDatabase(Context context){
        return Room.databaseBuilder(context,TrackMyWalletDatabase.class, "trackmywallet.db")
                .build();
    }

    @Provides
    @Singleton
    WalletDao provideWalletDao(TrackMyWalletDatabase trackMyWalletDatabase) {
        return trackMyWalletDatabase.walletDao();
    }

}
