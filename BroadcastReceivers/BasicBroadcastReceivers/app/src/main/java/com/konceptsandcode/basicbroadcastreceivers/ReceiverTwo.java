package com.konceptsandcode.basicbroadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ReceiverTwo extends BroadcastReceiver{
    private static final String TAG ="ReceiverTwo";

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("message");
        Log.d(TAG, ThreadUtils.getThreadInfo());
        Log.d(TAG, "Sleeping");
        ThreadUtils.sleepForSecs(2);
        Log.d(TAG, "Woke up");

        Log.d(TAG, "Message is:" + message);
    }
}
