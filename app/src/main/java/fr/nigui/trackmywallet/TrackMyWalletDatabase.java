package fr.nigui.trackmywallet;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by g-lap on 27/01/2018.
 */
@Database(entities = {Wallet.class}, version = 1)
public abstract class TrackMyWalletDatabase extends RoomDatabase {

    public abstract WalletDao walletDao();

}
