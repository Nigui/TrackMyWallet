package fr.nigui.trackmywallet.data.remote.model;

/**
 * Created by g-lap on 03/02/2018.
 */

public class WalletBalanceApiResponse {

    private String result;
    private String message;
    private String status;


    public WalletBalanceApiResponse(String result, String message, String status) {
        this.result = result;
        this.message = message;
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
