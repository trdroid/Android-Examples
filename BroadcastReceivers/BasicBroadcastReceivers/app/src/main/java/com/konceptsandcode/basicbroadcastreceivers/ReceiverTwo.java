package com.konceptsandcode.basicbroadcastreceivers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
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
        this.sendNotification(context, message);
    }

    private void sendNotification(Context context, String message) {
        /*
            ask the context for a system service called Context.NOTIFICATION_SERVICE
            to get the NotificationManager
         */
        NotificationManager notificationManager =
                (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        /*
            Initialize details of Notification
         */
        int icon = R.drawable.droid;
        CharSequence tickerText = "I am tickerText";
        long when = System.currentTimeMillis();

        /*
            Define the intent that should fire when the notification is selected
         */
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        /*
            Create a Notification using the Builder object which creates the content view for the Notification
            based on the parameters passed to it like title and text.
            The content view of a Notification is displayed when the notification is expanded by swiping down the
            status bar.

            The content view should be a RemoteViews object.

            By default, the Builder object creates a RemoteViews object and associates it with the notification.

            However, custom RemoteView instances can be created to be a content view for a Notification.
         */
        Notification notification =
                new Notification.Builder(context)
                .setContentTitle("Title")
                .setContentText(tickerText)
                .setSmallIcon(icon)
                .setWhen(when)
                .setContentIntent(pendingIntent)
                .setContentInfo("Content Information")
                .build();  //required: minSdkVersion 16

        /*
            Send notification.

            arg1: is unique ID (with in the application) that can be used to cancel the notification at a later point
            in time or to update the notification by creating a new notification and resending it against this id
         */
        notificationManager.notify(1, notification);
    }
}
