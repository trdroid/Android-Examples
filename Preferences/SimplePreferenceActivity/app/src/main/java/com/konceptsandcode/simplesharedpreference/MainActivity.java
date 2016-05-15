package com.konceptsandcode.simplesharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resources = this.getResources();

        /*
            Preferences file is saved by default as: <package name>_preferences.xml
            MODE_PRIVATE indicates that the preference file can only be opened by the application that created it
         */

        // There are two ways to get to the preferences

        /*
            1) getSharedPreferences() retrieves the preferences using a package name.
         */
        preferences = getSharedPreferences("com.konceptsandcode.simplesharedpreference_preferences",
                MODE_PRIVATE);

        /*
            2) PreferenceManager.getDefaultSharedPreferences() gets the default preferences for the current context
         */
        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(this);

        /*
            Once a reference to the preference is obtained, call getter method with an appropriate key to
            get the value of the preference.
         */

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
            for allowBlueTooth is written and committed to sample.xml file.
         */

        /*
            A custom name can be assigned to a preference file using a PreferenceManager

            To get a PreferenceManager instance, use getPreferenceManager() method
            getPreferenceManager() is NOT AVAILABLE when our Activity inherits from AppCompatActivity.

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
        /*
            A good approach is to define the key name as a string resource and use it with getters
            This avoids any unintended results that could occur because of typos,

            The same goes with the default values, whenever possible define default values in the
            string resource file and use it in getters
         */
        String settingsInText = "BlueTooth:" + preferences.getBoolean(resources.getString(R.string.bluetooth_pref), false);

        Toast.makeText(this, settingsInText, Toast.LENGTH_LONG).show();
    }

    public void onEditPreferencesButtonClick(View view) {
        CheckBox bluetoothCheckBox = (CheckBox)findViewById(R.id.enableBluetoothCheckBox);
        SharedPreferences.Editor preferencesEditor = preferences.edit();
        preferencesEditor.putBoolean(resources.getString(R.string.bluetooth_pref), bluetoothCheckBox.isChecked());
        preferencesEditor.commit();
    }
}
