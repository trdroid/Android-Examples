package com.konceptsandcode.threadfromactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private static String TAG = "MainActivity";
    private boolean isActivityPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        Runnable work = new Runnable() {
          public void run() {
              doSomething();
          }
        };

        Thread worker = new Thread(work);

        worker.start();
    }

    /*
        The worker thread runs in the background even after the activity is paused

        To avoid this behavior, use a flag

        Each click on a button spawns a thread
     */
    private void doSomething() {
        Log.d(TAG, "Started");

        try {
            for(Integer iter = 0; iter < 50; iter++) {
                /*
                    Only do the actual work when the activity is not paused.
                    When paused, just iterate through the loop and terminate.

                    TODO: Implement a counter that will resume counting after an activity resumes.  Use the same thread instance.
                 */
                if(!isActivityPaused)
                {
                    Log.d(TAG, iter.toString());
                    Thread.sleep(1000);
                }
            }
        }catch(InterruptedException e){}

        Log.d(TAG, "Done");
    }

    @Override
    protected void onPause() {
        isActivityPaused = true;
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isActivityPaused = false;
    }
}
