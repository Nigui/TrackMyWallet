package fr.nigui.trackmywallet;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import fr.nigui.trackmywallet.databinding.WalletBinding;

/**
 * Created by g-lap on 28/01/2018.
 */

public class WalletActivity extends AppCompatActivity {

    private static final String WALLETADDRESS_KEY = "walletAddress";

    WalletViewModel walletViewModel;

    WalletBinding walletBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        walletBinding = DataBindingUtil.setContentView(this,R.layout.wallet);

        String walletID = getIntent().getStringExtra(WALLETADDRESS_KEY);

        walletViewModel = ViewModelProviders.of(this).get(WalletViewModel.class);
        walletViewModel.init(walletID);

        walletViewModel.getWallet().observe(this, wallet -> {

            if( wallet != null ) {
                walletBinding.walletAddress.setText(wallet.getAddress());
                walletBinding.walletLabel.setText(wallet.getLabel());
                walletBinding.walletBalance.setText(wallet.getBalance());
            } else {
                //TODO manage
                System.out.println("LiveData<Wallet> is null");
            }

        });

    }

}
