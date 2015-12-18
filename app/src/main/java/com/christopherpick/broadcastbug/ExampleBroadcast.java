package com.christopherpick.broadcastbug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

/**
 * Created by chris.pick on 12/17/15.
 */
public class ExampleBroadcast extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Got Broadcast", Toast.LENGTH_LONG).show();
        android.util.Log.e("CTP", "NOTIFY CHANGE " + intent.getAction());
    }
}
