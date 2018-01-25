package fr.nigui.trackmywallet;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by g-lap on 25/01/2018.
 */

public class WalletFragment extends Fragment {

    private static final String ADDRESS_KEY = "address";
    private static final String BALANCE_KEY = "balance";
    private static final String LABEL_KEY = "label";

    private WalletViewModel walletViewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String walletAddress = getArguments().getString(ADDRESS_KEY);
        String walletBalance = getArguments().getString(BALANCE_KEY);
        String walletLabel = getArguments().getString(LABEL_KEY);

        walletViewModel = ViewModelProviders.of(this).get(WalletViewModel.class);
        walletViewModel.init(walletAddress,walletBalance,walletLabel);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.wallet,container,false);
    }
}
