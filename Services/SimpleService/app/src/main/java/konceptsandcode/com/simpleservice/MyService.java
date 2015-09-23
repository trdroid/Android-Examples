package konceptsandcode.com.simpleservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/*
    Service runs on the same thread as the activity
 */
public class MyService extends Service
{
    public MyService()
    {
    }

    /*
        onBind() allows to bind an activity to a service. This allows the activity to directly access members and methods of the service.
     */
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    /*
        onStartCommand() is called when the service is explicitly started using the startService() method
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();

        //Return START_STICKY to let the service continue running until explicitly stopped
        return START_STICKY;
    }

    /*
        onDestroy() is called when the service is stopped using the stopService() method
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Stopped and Destroyed", Toast.LENGTH_LONG).show();
    }
}
