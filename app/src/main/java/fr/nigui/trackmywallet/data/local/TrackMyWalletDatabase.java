package fr.nigui.trackmywallet.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import fr.nigui.trackmywallet.data.local.dao.ExchangePriceDao;
import fr.nigui.trackmywallet.data.local.dao.WalletDao;
import fr.nigui.trackmywallet.data.local.entity.ExchangePrice;
import fr.nigui.trackmywallet.data.local.entity.Wallet;
import fr.nigui.trackmywallet.data.model.CryptoCurrency;
import fr.nigui.trackmywallet.data.model.FiatCurrency;

/**
 * Created by g-lap on 27/01/2018.
 */
@Database(entities = {Wallet.class, ExchangePrice.class}, version = 1)
@TypeConverters({
        CryptoCurrency.class,
        FiatCurrency.class})
public abstract class TrackMyWalletDatabase extends RoomDatabase {

    public abstract WalletDao walletDao();

    public abstract ExchangePriceDao exchangePriceDao();

}
