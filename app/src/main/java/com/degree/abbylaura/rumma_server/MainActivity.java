package com.degree.abbylaura.rumma_server;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.degree.abbylaura.rumma_server.Server.Server;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("1: Main Activity onCreate");

        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Server.TRANSACTION_DONE);
        registerReceiver(clientReceiver, intentFilter);

    }

    private BroadcastReceiver clientReceiver = new BroadcastReceiver() {

        // Called when the broadcast is received
        @Override
        public void onReceive(Context context, Intent intent) {

            System.out.println("In broadcast receiver");

        }
    };

    public void onStartServerClick(View view) {

        System.out.println("In MA on click");

        Intent intent = new Intent(this, Server.class);
        this.startService(intent);

    }
}
