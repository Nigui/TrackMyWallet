package fr.nigui.trackmywallet.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import fr.nigui.trackmywallet.data.converters.CryptoCurrencyConverters;
import fr.nigui.trackmywallet.data.converters.FiatCurrencyConverters;
import fr.nigui.trackmywallet.data.local.dao.ExchangePriceDao;
import fr.nigui.trackmywallet.data.local.entity.ExchangePrice;
import fr.nigui.trackmywallet.data.local.entity.Wallet;
import fr.nigui.trackmywallet.data.local.dao.WalletDao;

/**
 * Created by g-lap on 27/01/2018.
 */
@Database(entities = {Wallet.class,ExchangePrice.class}, version = 1)
@TypeConverters({
        CryptoCurrencyConverters.class,
        FiatCurrencyConverters.class})
public abstract class TrackMyWalletDatabase extends RoomDatabase {

    public abstract WalletDao walletDao();
    public abstract ExchangePriceDao exchangePriceDao();

}
