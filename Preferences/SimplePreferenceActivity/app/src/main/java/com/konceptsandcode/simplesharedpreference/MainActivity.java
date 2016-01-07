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
            preferences = getSharedPreferences("sample", MODE_PRIVATE);

            onSetPreferencesButtonClick invokes the SharedPreferenceActivity, which
            displays the UI from the preferences files (R.xml.preferences)
            and creates a file data/data/<package name>/shared_prefs/<package name>_preferences.xml

            onReadPreferencesButtonClick attempts to read a preference with key allowBluetooth
            from the file data/data/<package name>/shared_prefs/sample.xml, which does not exist,
            so the attempt returns the default value mentioned, which is false

            onEditPreferencesButtonClick does preferences.edit() WHICH IS WHEN THE FILE
            (data/data/<package name>/shared_prefs/sample.xml) IS CREATED and the preference value
            for allowBlueTooth is written and commited to sample.xml file.
         */

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
