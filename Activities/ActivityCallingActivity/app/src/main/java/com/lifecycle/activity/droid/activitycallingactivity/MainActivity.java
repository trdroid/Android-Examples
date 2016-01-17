package com.lifecycle.activity.droid.activitycallingactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button launchButton = (Button)findViewById(R.id.launch_button);
        launchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*
                    Intent(Context packageContext, Class<?> cls)

                    The following is an explicit intent:

                    Context informs the ActivityManager the package that the class object (SecondActivity) is in
                    cls informs the ActivityManager which class to start i.e. the class to instantiate and call onCreate() method on

                    An explicit intent is used to start an Activity within the application

                    In contrast, an Implicit intent is used to start an Activity in another application
                 */
                Intent startSecondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                startSecondActivityIntent.putExtra(SecondActivity.EXTRA_MESSAGE, R.string.message1);
                startSecondActivityIntent.putExtra(SecondActivity.INFORM_MESSAGE, R.string.inform_message);

                /*
                    When startActivity(intent) is called, the call is sent to the ActivityManager of Android OS.

                    The ActivityManager creates an instance of the called Activity (SecondActivity, in this case)
                     and calls its onCreate() method
                 */
                startActivity(startSecondActivityIntent);

                Log.d(TAG, "startActivity() is a synchronous call");
            }
        });

        Button launchButtonForResult = (Button)findViewById(R.id.launch_button_for_result);

        launchButtonForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSecondActivityForResultIntent = new Intent(MainActivity.this, SecondActivity.class);

                /*
                    For the key in putExtra() method, the convention is to use a constant from the Child Activity class
                    which receives and processes the data

                    Question
                    ~~~~~~~~~~~~~~~~~~

                    What if an Explicit Intent is used to invoke an Activity from another application package?

                    Say, if MainActivity invokes an Activity called ExternalActivity from a different application package
                    In that case, how can a constant defined in ExternalActivity be accessed? for eg. ExternalActivity.EXTRA_MESSAGE
                    defined in ExternalActivity
                 */
                startSecondActivityForResultIntent.putExtra(SecondActivity.EXTRA_MESSAGE, R.string.message2);
                startSecondActivityForResultIntent.putExtra(SecondActivity.INFORM_MESSAGE, R.string.inform_message);

                /*
                    startActivityForResult(intent, requestCode)

                    is used when the Parent Activity expects the Child Activity to send it results,
                    which is handled by

                        protected void onActivityResult(int requestCode, int resultCode, Intent data)

                    callback defined below

                    The requestCode is sent to the child activity which returns it back to the parent Activity
                        when sending the results

                    It is used when the parent Activity starts more than one Child Activity to
                        identify which child activity is responding with the results
                 */
                startActivityForResult(startSecondActivityForResultIntent, 0);

                Log.d(TAG, "startActivityForResult() is a synchronous call");
            }
        });
    }

    /*
        When a Child Activity started with startActivityForResult() method returns the results, the following callback method,
          onActivityResult() is called

        The requestCode is a custom identification number sent to the Child Activity at the time of starting it
            with startActivityForResult() method

        The resultCode is sent back to the Parent Activity when the Child Activity responds with a result.

        It is used to by the Parent Activity to identify which Child Activity responded with the result.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*
            Question
            ~~~~~~~~

            What is the best convention to define requestCodes?

            Where? as constants in the same file, or a separate file or enums?
         */

        if(data == null) {
            return;
        }

        switch(requestCode) {
            case 0:
                int message = data.getIntExtra(SecondActivity.RESULT, -1);
                Toast.makeText(getApplicationContext(), String.valueOf(message), Toast.LENGTH_SHORT).show();
        }
    }
}
