package com.lifecycle.activity.droid.activitycallingactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    /*
        Since any Activity can start SecondActivity, the convention is to define the keys for EXTRAS in the
        Activity that retrieves and processes the attached data, which is SecondActivity

        Therefore, by convention, define the following String constant, that can be used by the Activities
        calling SecondActivity when sending data through the intent

        This applies to both the incoming and the outgoing EXTRAS which act as an "interface" for the SecondActivity

        To prevent name collisions with extras from other apps, add the package name as a prefix to the constant
     */
    public static final String EXTRA_MESSAGE = "com.lifecycle.activity.droid.activitycallingactivity.message";
    public static final String INFORM_MESSAGE = "com.lifecycle.activity.droid.activitycallingactivity.inform";

    public static final String RESULT = "com.lifecycle.activity.droid.activitycallingactivity.result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        /*
            getIntent() returns the Intent object sent from startActivity(intent)
            getXXXExtra() method returns the data attached to the intent
         */
        int message1ResourceId = getIntent().getIntExtra(EXTRA_MESSAGE, -1);
        int message2ResourceId = getIntent().getIntExtra(INFORM_MESSAGE, -1);

        /*
            Get the resource name from the resource id
            ------------------------------------------

            String message1 = getResources().getResourceEntryName(message1ResourceId);
            String message2 = getResources().getResourceEntryName(message2ResourceId);
         */

        String message1 = getResources().getString(message1ResourceId);
        String message2 = getResources().getString(message2ResourceId);

        Toast.makeText(getApplicationContext(), message1 + "\n" + message2, Toast.LENGTH_LONG).show();

        Button closeButton = (Button)findViewById(R.id.close_button);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                    'this' in onClick() method refers to an instance of type View.OnClickListener, but not of type SecondActivity
                    To refer to outer this, use SecondActivity.this
                 */

                /*
                    calling finish() is similar to hitting the back button which pops the instance of
                    SecondActivity from the Activity stack
                 */
                SecondActivity.this.finish();
            }
        });

        Button returnResultButton = (Button)findViewById(R.id.return_result_button);

        returnResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();

                result.putExtra(RESULT, 10);

                /*
                    setResult() method can be used in the Child Activity to send data back to the Parent Activity.
                      After the Child Activity is destroyed (say, after pressing the back button) the ActivityManager calls the
                      onActivityResult(int requestCode, int resultCode, Intent data) method of the parent Activity

                     setResult(int resultCode)

                     Intent implies the data that would be passed to the Parent Activity
                     setResult(int resultCode, Intent data)
                 */
                setResult(RESULT_OK, result);
            }
        });
    }
}
