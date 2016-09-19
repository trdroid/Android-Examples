### Goal

The goal is to schedule to run a task periodically to performs tasks like

* reminding the user to perform an action
* communicating with the server to check for updates

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.gruprog.settingalarm.MainActivity">

    <Button
        android:id="@+id/start_task"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Start Task" />

    <Button
        android:id="@+id/stop_task"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Stop Task" />

</LinearLayout>
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.gruprog.settingalarm">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <service
            android:name=".AlarmSettingService"
            android:enabled="true"
            android:exported="true"></service>
    </application>

</manifest>
```

```java
package com.gruprog.settingalarm;

import android.app.Service;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.IBinder;
import android.widget.Toast;

public class AlarmSettingService extends Service {
    public AlarmSettingService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String message = "Hello World!";

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        return START_NOT_STICKY;
    }
}
```

```java
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
```
