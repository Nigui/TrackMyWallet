package fr.nigui.trackmywallet.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import fr.nigui.trackmywallet.data.local.entity.Wallet;
import fr.nigui.trackmywallet.data.local.dao.WalletDao;

/**
 * Created by g-lap on 27/01/2018.
 */
@Database(entities = {Wallet.class}, version = 1)
public abstract class TrackMyWalletDatabase extends RoomDatabase {

    public abstract WalletDao walletDao();

}
