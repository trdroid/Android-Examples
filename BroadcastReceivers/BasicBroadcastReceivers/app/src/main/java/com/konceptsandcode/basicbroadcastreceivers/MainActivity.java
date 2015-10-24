package com.konceptsandcode.basicbroadcastreceivers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendBroadcastClick(View view) {
        Log.d(TAG, ThreadUtils.getThreadInfo());

        Intent broadcastIntent = new Intent("com.konceptsandcode.intents.uniquemessage");

        broadcastIntent.putExtra("message", "Message from MainActivity");

        this.sendBroadcast(broadcastIntent);

        Log.d(TAG, "Sent a broadcast message");
    }
}
