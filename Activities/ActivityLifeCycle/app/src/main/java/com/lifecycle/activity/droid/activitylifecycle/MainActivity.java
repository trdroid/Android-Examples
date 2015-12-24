package com.lifecycle.activity.droid.activitylifecycle;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    private final static String TAG = "MainActivity";

    /*
        Android calls onCreate() after the activity instance is created but before it is displayed
         on the screen

        A set of general steps taken in onCreate() method are:

            1. call the super's onCreate() method
            2. inflate the activity's view
            3. Get references to the widgets in the view
            4. Set listeners to respond to events on the widgets
            5. Perform CRUD operations on the model

        The @Override annotation makes sure that the method it is annotated with is actually a
        method of the parent class that is being overridden and that there are no typos.

        If the method does not match with a method in the parent class, the compiler complains.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
            Calling super class's onCreate before any code is very important for onCreate method,
            however the order is not a matter of concern for other lifecycle methods
         */
        super.onCreate(savedInstanceState);

        /*
            Log.d(<source of message>, <message itself>)
         */
        Log.d(TAG, "onCreate()");

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}
