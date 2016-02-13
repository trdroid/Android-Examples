package konceptsandcode.com.simpleservice;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/*
    A Service can communicate with an Activity, say about the completion of its task,
    by sending a broadcast
 */
public class MyIntentService extends IntentService
{
    public MyIntentService()
    {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        Log.d("MY_INTENT_SERVICE", "Starting Task ...");

        try {
            for(int iter = 0; iter < 5; iter++) {
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){}

        Log.d("MY_INTENT_SERVICE", "Sending a broadcast to let MainActivity know that the task is done.");

        /*
            Broadcast a message to the MainActivity to indicate that the task is done.
            
            The action is an arbitray identifier which should be unique. Java's package namespace can be used here.
         */
        Intent broadcastIntent = new Intent().setAction("TASK_FINISHED");
        getBaseContext().sendBroadcast(broadcastIntent);

        Log.d("MY_INTENT_SERVICE", "Ending Task ...");
    }
}
