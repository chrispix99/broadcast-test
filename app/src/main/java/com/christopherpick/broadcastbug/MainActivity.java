package com.christopherpick.broadcastbug;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.christopherpick.broadcastbug.service.ExampleSyncService;
import com.christopherpick.broadcastbug.utils.SyncUtils;

public class MainActivity extends AppCompatActivity {
    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account = SyncUtils.getSyncAccount(MainActivity.this, "com.christopherpick.broadcastbug.providers.exampleprovider", MainActivity.this.getString(R.string.example_sync_account_type));
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.util.Log.e("CTP", "start NEW Send BroadcastE account already created");

                ExampleSyncService.requestSyncNow(MainActivity.this, null, account);
                //Intent intent2 = new Intent("com.christopherpick.broadcastbug.TEST_ONE");
                Intent intent2 = new Intent(MainActivity.this, ExampleBroadcast.class);
                sendBroadcast(intent2);
                android.util.Log.e("CTP", "end NEW Send BroadcastE account already creted");            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    android.util.Log.e("CTP", "start NEW Send BroadcastE");
                    ExampleSyncService.requestSyncNow(MainActivity.this, null);
                    Intent intent2 = new Intent(MainActivity.this, ExampleBroadcast.class);
                    sendBroadcast(intent2);
                    android.util.Log.e("CTP", "end NEW Send BroadcastE");

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
