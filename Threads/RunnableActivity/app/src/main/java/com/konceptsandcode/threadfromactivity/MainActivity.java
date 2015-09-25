package com.konceptsandcode.threadfromactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/*
    If the main purpose of the Activity is to run a time-consuming operation, the Activity can implement Runnable
 */
public class MainActivity extends AppCompatActivity implements Runnable
{
    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        new Thread(this).start();
    }

    @Override
    public void run() {
        doSomething();
    }

    private void doSomething() {
        Log.d(TAG, "Started");

        try {
            for(Integer iter = 0; iter < 50; iter++) {
                    Log.d(TAG, iter.toString());
                    Thread.sleep(1000);
            }
        }catch(InterruptedException e){}

        Log.d(TAG, "Done");
    }
}
