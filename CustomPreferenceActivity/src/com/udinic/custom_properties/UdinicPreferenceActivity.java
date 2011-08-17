package com.udinic.custom_properties;

import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.ListView;

public class UdinicPreferenceActivity extends PreferenceActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.udinic_pref);

        // Setting the list's background to be black
        ListView lv = (ListView)findViewById(android.R.id.list);
        lv.setBackgroundColor(Color.WHITE);
    }
}
