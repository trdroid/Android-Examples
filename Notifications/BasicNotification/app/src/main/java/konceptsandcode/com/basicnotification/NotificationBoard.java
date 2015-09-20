package konceptsandcode.com.basicnotification;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NotificationBoard extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_board);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationID = getIntent().getExtras().getInt("notificationID");

        /*
            Cancel the notification once the user taps on the notification from the notifications list.
            Without this, the notification can still be seen in the status bar.
         */
        notificationManager.cancel(notificationID);
    }
}
