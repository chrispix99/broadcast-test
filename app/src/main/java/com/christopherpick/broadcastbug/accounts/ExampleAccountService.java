package com.christopherpick.broadcastbug.accounts;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.net.Authenticator;

/**
 * Created by chris.pick on 12/17/15.
 */
public class ExampleAccountService extends Service {

        // Instance field that stores the authenticator object
        private ExampleAccountAuthenticator mAuthenticator;
        @Override
        public void onCreate() {
            // Create a new authenticator object
            mAuthenticator = new ExampleAccountAuthenticator(this);
        }
        /*
         * When the system binds to this Service to make the RPC call
         * return the authenticator's IBinder.
         */
        @Override
        public IBinder onBind(Intent intent) {
            return mAuthenticator.getIBinder();
        }

}
