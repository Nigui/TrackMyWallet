package fr.nigui.trackmywallet;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by g-lap on 27/01/2018.
 */
@Entity
public class Wallet {

    @PrimaryKey
    @NonNull
    private String address;
    private String balance;
    private String label;

    public Wallet(String address, String balance, String label) {
        this.address = address;
        this.balance = balance;
        this.label = label;
    }

    public String getAddress() {
        return address;
    }

    public String getBalance() {
        return balance;
    }

    public String getLabel() {
        return label;
    }

}
