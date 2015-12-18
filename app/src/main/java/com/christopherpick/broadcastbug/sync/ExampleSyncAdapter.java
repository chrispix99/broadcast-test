package com.christopherpick.broadcastbug.sync;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by chris.pick on 12/17/15.
 */
public class ExampleSyncAdapter extends AbstractThreadedSyncAdapter {

    private static final String TAG = ExampleSyncAdapter.class.getSimpleName();

    public ExampleSyncAdapter(Context context) {
        super(context, true);
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {
        Log.e(TAG, ">>> StartSync");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "<<< EndSync");

    }
}
