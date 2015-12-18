package com.christopherpick.broadcastbug.utils;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class SyncUtils {
    public static final Bundle SYNC_NOW_BUNDLE = new Bundle();

    public SyncUtils() {
    }

    public static Account getSyncAccount(Context context, String accountName, String accountType) {
        Account account = new Account(accountName, accountType);
        AccountManager accountManager = AccountManager.get(context);
        accountManager.addAccountExplicitly(account, (String)null, (Bundle)null);
        return account;
    }



    static {
        SYNC_NOW_BUNDLE.putBoolean("force", true);
        SYNC_NOW_BUNDLE.putBoolean("expedited", true);
        SYNC_NOW_BUNDLE.putBoolean("do_not_retry", true);
    }
}
