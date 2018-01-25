package fr.nigui.trackmywallet;

import android.arch.lifecycle.ViewModel;

/**
 * Created by g-lap on 25/01/2018.
 */

public class WalletViewModel extends ViewModel {

    private String address;
    private String balance;
    private String label;

    public void init(String address,String balance,String label){
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
