package android.example.com.visualizerpreferences;

/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

// TODO (1) Implement OnSharedPreferenceChangeListener
public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {

        // Add visualizer preferences, defined in the XML file in res->xml->pref_visualizer
        addPreferencesFromResource(R.xml.pref_visualizer);

        // TODO (3) Get the preference screen, get the number of preferences and iterate through
        // all of the preferences if it is not a checkbox preference, call the setSummary method
        // passing in a preference and the value of the preference

        PreferenceScreen preferenceScreen = getPreferenceScreen();
        int numberOfPreferences = preferenceScreen.getPreferenceCount();
        SharedPreferences sharedPreferences = preferenceScreen.getSharedPreferences();

        for (int i = 0; i < numberOfPreferences; i++) {  // Go thru all preferences in prefscreen
            Preference potentialPreference = preferenceScreen.getPreference(i);

            if (!(potentialPreference instanceof CheckBoxPreference)) {  // Checking for chBox because it is structurally different and will cause nullPointer.
                String value = sharedPreferences.getString(potentialPreference.getKey(), "");
                setPreferenceSummary(potentialPreference, value);
            }

        }

    }

    // TODO (4) Override onSharedPreferenceChanged and, if it is not a checkbox preference,
    // call setPreferenceSummary on the changed preference

    /**
     * ONSHAREDPREFERENCECHANGED - CALLED WHEN THE PREFERENCE CHANGES
     * @param sharedPreferences
     * @param s - THE KEY
     */
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        // Find the Preference that was changed
        Preference preference = findPreference(s);

        if (preference != null) {
            if (!(preference instanceof CheckBoxPreference)) {  // Checkboxes are built slightly different an may cause Exceptions
                String value = sharedPreferences.getString(preference.getKey(), "");
                setPreferenceSummary(preference, value);  // There are conditionals in side to tell whether this is appropriate
            }
        }

    }


    // TODO (2) Create a setPreferenceSummary which takes a Preference and String value as parameters.
    // This method should check if the preference is a ListPreference and, if so, find the label
    // associated with the value. You can do this by using the findIndexOfValue and getEntries methods
    // of Preference.
    public void setPreferenceSummary(Preference preference, String value) {
        if (!(preference instanceof CheckBoxPreference)) {
            if (preference instanceof ListPreference) {
                int chosenIndex = ((ListPreference) preference).findIndexOfValue(value);
                CharSequence[] choiceArr = ((ListPreference) preference).getEntries();
                preference.setSummary(choiceArr[chosenIndex]);  // We want to set the Summary to the label, so translated proper
            }
        }

    }

    // TODO (5) Register and unregister the OnSharedPreferenceChange listener (this class) in
    // onCreate and onDestroy respectively.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get sharedPreferences and register with the Listener
        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Get sharedPreferences and unregister with the Listener
        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }
}