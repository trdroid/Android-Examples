package konceptsandcode.com.simpleservice;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.widget.Toast;

import java.io.File;
import java.net.URL;

/*
    Service runs on the same thread as the activity
 */
public class MyService extends Service
{
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

        File[] files = new File[5];
        DataCompressor imageProcessor = new DataCompressor();

        /*
            Type of the array passed as an argument to execute() method matches the first type parameter of AsyncTask

            AsyncTask<File
         */
        imageProcessor.execute(files);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Stopped and Destroyed", Toast.LENGTH_LONG).show();
    }

    private void compress(File file) {
        /*
            Long running task
         */
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {}
    }

    /*
        The AsyncTask class enables a service to perform background execution without having to use threads explicitly.
     */
    private class DataCompressor extends AsyncTask<File, Integer, Float>
    {
        /*
            The argument type of doInBackground method is an array of type T where T is the first type
            parameter of AsyncTask
            AsyncTask<File

            The return type of doInBackground method matches the third type parameter of AsyncTask
            AsyncTask<~~,~~,Float>

            The value returned is sent as an argument to onPostExecute() method

            Long running code should be placed in this method which is executed in a background thread
         */
        @Override
        protected Float doInBackground(File... files)
        {
            int progress = 0;
            Float compressionRatio = 0.5f;

            for(int iter = 0; iter < files.length; iter++) {

                //invoke a long running task
                compress(files[iter]);

                progress += 20;
                /*
                    report progress of the task by calling publishProgress() method
                 */
                publishProgress(progress);
            }

            return compressionRatio;
        }

        /*
            The argument to onPostExecute method is an array of type T which is the second type argument of AsyncTask
            AsyncTask<~~, Integer

            This method runs in the main thread
        */
        @Override
        protected void onProgressUpdate(Integer... progress)
        {
            Toast.makeText(getBaseContext(), String.valueOf(progress[0]) + " %", Toast.LENGTH_LONG).show();
        }

        /*
            The argument type of onPostExecute method matches the third type argument of AsyncTask
            AsyncTask<~~,~~, Float>

            This method runs in the UI thread and is called when the doInBackground() method completes execution
         */
        @Override
        protected void onPostExecute(Float ratio)
        {
            /*
                Eg: Display a Toast or a Notification to indicate the user that the task is done
             */

            /*
                A service could be stopped when done
             */

            Toast.makeText(getBaseContext(), "Value received from doInBackground " + ratio, Toast.LENGTH_LONG).show();
            stopSelf();
        }
    }
}
