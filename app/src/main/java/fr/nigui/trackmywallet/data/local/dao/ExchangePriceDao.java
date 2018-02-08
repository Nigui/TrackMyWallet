package fr.nigui.trackmywallet.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import fr.nigui.trackmywallet.data.local.entity.ExchangePrice;
import fr.nigui.trackmywallet.data.model.CryptoCurrency;
import fr.nigui.trackmywallet.data.model.FiatCurrency;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by g-lap on 08/02/2018.
 */
@Dao
public interface ExchangePriceDao {

    @Insert(onConflict = REPLACE)
    void saveExchangePrice(ExchangePrice exchangePrice);

    @Update
    void updateExchangePrice(ExchangePrice exchangePrice);

    @Query("SELECT price FROM exchangeprice WHERE fiat = :fiat AND crypto = :crypto")
    LiveData<Double> getExchangePrice(FiatCurrency fiat, CryptoCurrency crypto);

}
