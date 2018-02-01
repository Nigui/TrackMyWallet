package fr.nigui.trackmywallet;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by g-lap on 27/01/2018.
 */
@Dao
public interface WalletDao {

    @Insert(onConflict = REPLACE)
    void save(Wallet wallet);

    @Query("SELECT * FROM wallet WHERE address = :walletID")
    LiveData<Wallet> load(String walletID);

}
