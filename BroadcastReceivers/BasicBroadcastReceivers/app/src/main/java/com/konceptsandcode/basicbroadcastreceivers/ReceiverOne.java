package com.konceptsandcode.basicbroadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ReceiverOne extends BroadcastReceiver {
    private static final String TAG ="ReceiverOne";

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("message");

        Log.d(TAG, ThreadUtils.getThreadInfo());
        Log.d(TAG, "Message is:" + message);
    }
}

