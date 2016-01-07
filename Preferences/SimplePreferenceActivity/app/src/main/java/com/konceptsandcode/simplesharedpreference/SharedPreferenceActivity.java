package com.konceptsandcode.simplesharedpreference;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/*
    Preferences are stored at /data/data/<package name>/shared_prefs directory
 */
public class SharedPreferenceActivity extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);

        /*
            Generates preferences UI from res/xml/preferences.xml
            and a file data/data/<package name>/shared_prefs/<package name>_preferences.xml
            to persist the preference values
         */
        addPreferencesFromResource(R.xml.preferences);
    }
}
