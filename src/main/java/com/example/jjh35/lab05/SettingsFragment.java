package com.example.jjh35.lab05;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by jjh35 on 10/7/2016.
 * Builds the setting fragment
 */
public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate( Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );
        addPreferencesFromResource(R.xml.preferences);
    }
}
