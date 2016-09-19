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
