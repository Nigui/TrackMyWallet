package fr.nigui.trackmywallet.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import fr.nigui.trackmywallet.data.local.entity.Wallet;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by g-lap on 27/01/2018.
 */
@Dao
public interface WalletDao {

    @Insert(onConflict = REPLACE)
    void saveWallet(Wallet wallet);

    @Query("SELECT * FROM wallet WHERE address = :walletID")
    LiveData<Wallet> getWallet(String walletID);

}
