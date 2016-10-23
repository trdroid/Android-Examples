package com.gruprog.basicpreferences;


import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int preferencesResId = getActivity().getResources().getIdentifier(
                getArguments().getString("fragment_preference_resource"),
                "xml",
                getActivity().getPackageName());

        addPreferencesFromResource(preferencesResId);
    }
}
