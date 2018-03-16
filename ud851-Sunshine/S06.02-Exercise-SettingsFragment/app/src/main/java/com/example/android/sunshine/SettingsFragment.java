package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.PreferenceFragmentCompat;

/**
 * Created by yasmeen on 1/19/2018.
 */

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preference_general);
        SharedPreferences sharedPreferences=getPreferenceScreen().getSharedPreferences();
        PreferenceScreen preferenceScreen=getPreferenceScreen();
        int count=preferenceScreen.getPreferenceCount();
        for(int i=0;i<count;i++)
        {
            Preference p= preferenceScreen.getPreference(i);
            if(!(p instanceof CheckBoxPreference))
            {
                String value=sharedPreferences.getString(p.getKey(),"");
                setPreferenceSummary(p,value);
            }
        }
    }

    private void setPreferenceSummary(Preference preference,Object Ovalue)
    {
        String value=(String)Ovalue;
        String key=preference.getKey();
        if(preference instanceof ListPreference)
        {
            ListPreference listPreference=(ListPreference)preference;
            int number=listPreference.findIndexOfValue(value);
            if(number>=0)
                listPreference.setSummary(listPreference.getEntries()[number]);

        }
        else
            preference.setSummary(value);

    }

    @Override
    public void onStart() {
        super.onStart();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference preference =findPreference(key);
        if(preference !=null) {
            if (!(preference instanceof CheckBoxPreference)) {
                setPreferenceSummary(preference,sharedPreferences.getString(key,""));
            }
        }

    }
}
