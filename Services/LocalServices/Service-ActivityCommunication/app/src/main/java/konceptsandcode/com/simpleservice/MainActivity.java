package konceptsandcode.com.simpleservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private IntentFilter intentFilter;

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            Toast.makeText(getBaseContext(), "Task Completed", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void onResume() {
        super.onResume();

        /*
            IntentFilter to filter intent for TASK_FINISHED that will be send by the Service once it finishes its task
         */
        intentFilter = new IntentFilter();
        intentFilter.addAction("TASK_FINISHED");

        /*
            Registering the broadcastReceiver (programmatically) to listen for broadcast messages
         */
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onServiceStartButtonClick(View view) {
        startService(new Intent(getBaseContext(), MyIntentService.class));
    }

    @Override
    public void onPause() {
        super.onPause();

        /*
            Unregister the broadcast receiver when the Activity pauses
            thereby ignoring broadcasted messages
         */

        unregisterReceiver(broadcastReceiver);
    }
}
