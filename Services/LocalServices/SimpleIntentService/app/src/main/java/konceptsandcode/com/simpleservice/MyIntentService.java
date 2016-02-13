package konceptsandcode.com.simpleservice;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/*
    Intent Service uses a worker thread to run its task.
    Unlike a Service, which has to be stopped explicitly, an IntentService terminates itself when the task completes.
 */
public class MyIntentService extends IntentService
{
    public MyIntentService()
    {
        /*
            Assign a name for the intent service's worker thread; useful for debugging
         */
        super("MyIntentService");
    }


    /*
        Code in onHandleIntent will be executed on a separate thread.
        The thread is terminated after the task finishes.
     */
    @Override
    protected void onHandleIntent(Intent intent)
    {
        /*
            Toast.makeText(this, "Starting Task ...", Toast.LENGTH_LONG).show();

            Since the code runs on a separate thread, UI cannot be accessed from onHandleIntent method
         */

        Log.d("MY_INTENT_SERVICE", "Starting Task ...");

        try {
            for(int iter = 0; iter < 5; iter++) {
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){}

        Log.d("MY_INTENT_SERVICE", "Ending Task ...");
    }
}
