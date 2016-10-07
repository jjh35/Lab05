package com.example.jjh35.lab05;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by jjh35 on 10/7/2016.
 * creates the setting activity class
 */
public class SettingsActivity  extends Activity {
    @Override
    public void onCreate( Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
