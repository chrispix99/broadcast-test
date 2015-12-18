package com.christopherpick.broadcastbug.service;

import android.accounts.Account;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import com.christopherpick.broadcastbug.R;
import com.christopherpick.broadcastbug.sync.ExampleSyncAdapter;
import com.christopherpick.broadcastbug.utils.SyncUtils;

/**
 * Created by chris.pick on 12/17/15.
 */
public class ExampleSyncService extends Service {

    private static ExampleSyncAdapter syncAdapter; // TODO: should this be static????
    private static final Object lock = new Object();


    public static void requestSyncNow(Context context, Bundle bundle) {
        Bundle syncBundle = SyncUtils.SYNC_NOW_BUNDLE;
        if (bundle != null) {
            syncBundle.putAll(bundle);
        }
        ContentResolver.requestSync(
                SyncUtils.getSyncAccount(context, "com.christopherpick.broadcastbug.providers.exampleprovider", context.getString(R.string.example_sync_account_type)),
                "com.christopherpick.broadcastbug.providers.exampleprovider",
                syncBundle);
    }

    public static void requestSyncNow(Context context, Bundle bundle, Account account) {
        Bundle syncBundle = SyncUtils.SYNC_NOW_BUNDLE;
        if (bundle != null) {
            syncBundle.putAll(bundle);
        }
        ContentResolver.requestSync(
                account,
                "com.christopherpick.broadcastbug.providers.exampleprovider",
                syncBundle);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        synchronized (lock) {
            syncAdapter = new ExampleSyncAdapter(this);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return syncAdapter.getSyncAdapterBinder();
    }

}
