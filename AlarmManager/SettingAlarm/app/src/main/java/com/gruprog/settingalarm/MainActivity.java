package com.gruprog.settingalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start_task).setOnClickListener(onClickListener);
        findViewById(R.id.stop_task).setOnClickListener(onClickListener);

        Intent intent = new Intent(this, AlarmSettingService.class);
        pendingIntent = PendingIntent.getService(this, 0, intent, 0);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
            long scheduleInterval = 10 * 1000;

            switch(view.getId()) {

                case R.id.start_task:
                    alarmManager.setRepeating(
                            AlarmManager.ELAPSED_REALTIME,
                            SystemClock.elapsedRealtime() + scheduleInterval,
                            scheduleInterval,
                            pendingIntent);

                    Toast.makeText(MainActivity.this, "Scheduled Alarm!", Toast.LENGTH_SHORT).show();

                    break;

                case R.id.stop_task:
                    Toast.makeText(MainActivity.this, "Cancelled Alarm!", Toast.LENGTH_SHORT).show();
                    alarmManager.cancel(pendingIntent);
                    break;

                default:
                    break;
            }
        }
    };
}
