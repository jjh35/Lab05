package com.example.jjh35.lab05;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.jjh35.lab05.R;

/**
 * Jesse Hulse, jjh35, lab5 Oct. 7.
 * This lab implements a simple menu and a preference option
 */

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private boolean preference = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        showPreferences();
    }

    /**
     * Shows the preference option
     */
    public void showPreferences()
    {
        TextView preference = (TextView) findViewById(R.id.preference);
        preference.setText("Preference: " + prefs.getBoolean( "preference", false ));
    }


    /**
     * saves the data when the app is suspended
     */
    @Override
    public void onPause()
    {
        super.onPause();
        preference = prefs.getBoolean("Preference", false);
        showPreferences();
    }

    /*
     *restores data once app is resumed
     */
    @Override
    public void onResume()
    {
        super.onResume();
        preference = prefs.getBoolean( "Preference", false );
        showPreferences();
    }

    /**
     * This function creates the menu
     *
     * @param menu
     *  the menu for the app
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * This function is the action listener for the menu options. If
     * one is pressed, then it will switch activities.
     *
     * @param item
     *  The menu option selected
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch ( item.getItemId() ) {
            case R.id.menu_settings :
               startActivity( new Intent( getApplicationContext(), SettingsActivity.class ) );
                return true;
            case R.id.menu_about:
               startActivity( new Intent( getApplicationContext(), AboutActivity.class ) );
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}