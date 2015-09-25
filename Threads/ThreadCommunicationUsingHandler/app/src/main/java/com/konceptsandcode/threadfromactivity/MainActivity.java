package com.konceptsandcode.threadfromactivity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

/*
    Scenario 1:
    A UI thread delegates a task by sending a message to a background time-consuming thread.
    The background thread, after finishing the time-consuming operation, sends a message back to the calling thread
    (the UI thread) with the results.

    Eg:
    The UI thread delegates the task of running a timer to the background thread.
    The background thread runs the timer and sends updates to the UI.

    Handlers are objects used for sending messages between threads.

    A handler bound to a "message receiving thread" (say, UI Thread) acts as a queue holding messages that should be
    handled by the UI Thread.

    A message is a runnable job that runs on the UI Thread, which makes reference to UI elements from these jobs possible.

    Any thread (UI or background) can schedule messages to be placed in the queue using the handler, so that these
    messages get processed in the UI Thread.

    UI Thread <-- Handler <-- Background Thread

    UI Thread --> Handler
              <--
 */
public class MainActivity extends AppCompatActivity
{
    private static String TAG = "MainActivity";
    private Handler handler = new Handler();

    private TextView timeTextView;

    private Runnable timeUpdater = new Runnable() {
        @Override
        public void run() {
            timeTextView.setText(new Date().toString());
            handler.postDelayed(timeUpdater, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeTextView = (TextView)findViewById(R.id.timeTextView);
        timeTextView.setText("TIME");

        Button startButton = (Button)findViewById(R.id.startButton);
        startButton.setText("Start");

        startButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (timeTextView.getText().equals("TIME"))
                {
                    handler.postDelayed(timeUpdater, 1000);
                }
            }
        });
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "Pausing...");
        handler.removeCallbacks(timeUpdater);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "Resuming...");
        if (!timeTextView.getText().equals("TIME")) {
            handler.postDelayed(timeUpdater, 1000);
        }
    }
}
