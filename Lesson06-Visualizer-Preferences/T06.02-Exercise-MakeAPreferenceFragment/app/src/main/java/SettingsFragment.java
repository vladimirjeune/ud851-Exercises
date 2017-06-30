import android.example.com.visualizerpreferences.R;
import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

/**
 * Created by vladimirjeune on 6/29/17.
 */

public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // Note that you have to go thru xml
        addPreferencesFromResource(R.xml.pref_visualizer);
    }
}
