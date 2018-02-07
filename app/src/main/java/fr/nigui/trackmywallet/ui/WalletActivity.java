package fr.nigui.trackmywallet.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import fr.nigui.trackmywallet.R;
import fr.nigui.trackmywallet.databinding.WalletBinding;

/**
 * Created by g-lap on 28/01/2018.
 */
public class WalletActivity extends AppCompatActivity {

    private static final String TAG = "WalletActivity";

    private static final String WALLETADDRESS_KEY = "walletAddress";
    private static final String WALLETADDRESS_DEFAULT = "0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a";

    WalletBinding walletBinding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    WalletViewModel walletViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        walletBinding = DataBindingUtil.setContentView(this, R.layout.wallet);
        walletViewModel = ViewModelProviders.of(this,viewModelFactory).get(WalletViewModel.class);

    }

    @Override
    protected void onResume() {
        super.onResume();

        String walletID = getIntent().getStringExtra(WALLETADDRESS_KEY);
        if( walletID == null ){
            walletID = WALLETADDRESS_DEFAULT;
        }

        walletViewModel.getWallet(walletID).observe(this, wallet -> {

            if( wallet != null ) {
                Log.d(TAG,"Wallet data loaded into view");
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
