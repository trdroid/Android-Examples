package konceptsandcode.com.simpleservice;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
    A Task Reminder app or an alarm app can make use of this service
 */
public class MyService extends Service
{
    private static final int INTERVAL = 2000;
    private Timer timer = new Timer();

    public MyService()
    {
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();

        //TimerTask runs on a separate thread
        timer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                /*
                    Toast.makeText(MainActivity.this, new Date().toString(), Toast.LENGTH_LONG).show();
                    Err: MainActivity is not an enclosing class

                    Toast.makeText(this, new Date().toString(), Toast.LENGTH_LONG).show();
                    Err: this is an instance of TimerTask

                    Toast.makeText(MyService.this, new Date().toString(), Toast.LENGTH_LONG).show();
                    (or)
                    Toast.makeText(getBaseContext(), new Date().toString(), Toast.LENGTH_LONG).show();
                    Err: throws a RuntimeException, because the thread which runs the run method is trying to access the UI
                    UI can only be accessed from the main/UI thread
                 */

                Log.d("REPEATED_MESSAGE", new Date().toString());
            }
        }, 0 /*Wait time before first execution of the task*/, INTERVAL /*How frequently to run the task*/);

        /*
            How frequently the task is schedule to run is independent of how long the task runs.
            In this example, the task would be schedule to execute every INTERVAL ms (2000 ms in this case)
         */
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "Service Stopped and Destroyed", Toast.LENGTH_LONG).show();
    }
}
