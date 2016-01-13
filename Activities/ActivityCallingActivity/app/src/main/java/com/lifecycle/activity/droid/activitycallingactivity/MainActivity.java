package com.lifecycle.activity.droid.activitycallingactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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
                 */
                Intent startSecondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);

                /*
                    When startActivity(intent) is called, the call is sent to the ActivityManager of Android OS.

                    The ActivityManager creates an instance of the called Activity (SecondActivity, in this case)
                     and calls its onCreate() method
                 */
                startActivity(startSecondActivityIntent);
            }
        });
    }
}
