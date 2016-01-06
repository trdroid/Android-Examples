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

        addPreferencesFromResource(R.xml.preferences);
    }
}
