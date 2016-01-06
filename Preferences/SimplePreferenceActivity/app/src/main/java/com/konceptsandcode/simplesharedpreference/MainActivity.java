package com.konceptsandcode.simplesharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

/*
    Use SharedPreference class to read/write preferences
 */
public class MainActivity extends AppCompatActivity
{
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            Preferences file is saved by default as: <package name>_preferences.xml
            MODE_PRIVATE indicates that the preference file can only be opened by the application that created it
         */

        preferences = getSharedPreferences("com.konceptsandcode.simplesharedpreference_preferences",
                MODE_PRIVATE);

        /*
            A custom name can be assigned to a preference file using a PreferenceManager

            A PreferenceManager instance can be obtained from getPreferenceManager() method
            that is NOT AVAILABLE when our Activity inherits from AppCompatActivity.

            To use getPreferenceManager, inherit from Activity.

            PreferenceManager prefManager = getPreferenceManager();
            prefManager.setSharedPreferencesName("connectivitySettings");

            "connectivitySettings.xml" is used as the preference file
         */

    }

    public void onSetPreferencesButtonClick(View view) {
        startActivity(new Intent(MainActivity.this, SharedPreferenceActivity.class));
    }

    public void onReadPreferencesButtonClick(View view) {
        String settingsInText = "BlueTooth:" + preferences.getBoolean("allowBluetooth", false);

        Toast.makeText(this, settingsInText, Toast.LENGTH_LONG).show();
    }

    public void onEditPreferencesButtonClick(View view) {
        CheckBox bluetoothCheckBox = (CheckBox)findViewById(R.id.enableBluetoothCheckBox);
        SharedPreferences.Editor preferencesEditor = preferences.edit();
        preferencesEditor.putBoolean("allowBluetooth", bluetoothCheckBox.isChecked());
        preferencesEditor.commit();
    }
}
