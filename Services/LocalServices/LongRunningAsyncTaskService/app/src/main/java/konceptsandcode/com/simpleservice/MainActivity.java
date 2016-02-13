package konceptsandcode.com.simpleservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/*
    After launching the app, hitting the home button still displays Toasts from the Service running in the background
 */
public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onServiceStartButtonClick(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
    }

    public void onServiceStopButtonClick(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }
}
