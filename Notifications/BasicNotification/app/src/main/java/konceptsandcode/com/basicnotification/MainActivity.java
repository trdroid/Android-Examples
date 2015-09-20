package konceptsandcode.com.basicnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    int notificationID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDisplayNotificationClick(View view) {
        //Get the notification manager service
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        /*
            Define the behavior when the user selects a notification from the list of notifications.
            In this case, launch NotificationBoard activity.
         */
        Intent intent = new Intent(this, NotificationBoard.class);
        intent.putExtra("notificationID", notificationID);

        final int requestCode = 0, flags = 0;

        /*
            A PendingIntent object performs an action on behalf of the application, often at a later time, even when
            the application is not running.
         */
        PendingIntent pendingIntent = PendingIntent.getActivity(this, requestCode, intent, flags);

        //The following message is displayed on the status bar when the notification occurs
        CharSequence messageOnStatusBar = "Books due - Library";

        //The following two messages details will be displayed on dragging the status bar down
        CharSequence sender = "Library";
        CharSequence message = "It's time to return the book to the library";

        final Notification notification = new Notification(
                R.mipmap.ic_launcher,
                messageOnStatusBar,
                System.currentTimeMillis()
        );

        notification.vibrate = new long[] {100, 200, 300, 200, 100};
        notification.setLatestEventInfo(this, sender, message, pendingIntent);

        notificationManager.notify(notificationID, notification);
    }
}
