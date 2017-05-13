package com.example.android.lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
     * This tag will be used for logging. It is best practice to use the class's name using
     * getSimpleName as that will greatly help to identify the location from which your logs are
     * being posted.
     */
    private static final String TAG = MainActivity.class.getSimpleName();

    /* Constant values for the names of each respective lifecycle callback */
    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";
    private static final String ON_SAVE_INSTANCE_STATE = "onSaveInstanceState";

    /*
     * This TextView will contain a running log of every lifecycle callback method called from this
     * Activity. This TextView can be reset to its default state by clicking the Button labeled
     * "Reset Log"
     */
    private TextView mLifecycleDisplay;

    /**
     * Called when the activity is first created. This is where you should do all of your normal
     * static set up: create views, bind data to lists, etc.
     *
     * Always followed by onStart().
     *
     * @param savedInstanceState The Activity's previously frozen state, if there was one.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLifecycleDisplay = (TextView) findViewById(R.id.tv_lifecycle_events_display);

        // TODOne (1) Use logAndAppend within onCreate
        logAndAppend(ON_CREATE);
    }

    // TODOne (2) Override onStart, call super.onStart, and call logAndAppend with ON_START
    /**
     * ONSTART - makes the activity visible to the user, as the app prepares for the activity to enter the foreground
     * and become interactive. For example, this method is where the app initializes the code that maintains
     * the UI. It might also register a BroadcastReceiver that monitors changes that are reflected in the UI.
     *
     * The onStart() method completes very quickly and, as with the Created state, the activity does not stay
     * resident in the Started state. Once this callback finishes, the activity enters the Resumed state, and
     * the system invokes the onResume() method.
     */
    @Override
    protected void onStart() {
        super.onStart();

        logAndAppend(ON_START);
    }


    // TODOne (3) Override onResume, call super.onResume, and call logAndAppend with ON_RESUME
    /**
     * ONRESUME - When the activity enters the Resumed state, it comes to the foreground, and then
     * the system invokes the onResume() callback. This is the state in which the app interacts with
     * the user. The app stays in this state until something happens to take focus away from the app.
     * Such an event might be, for instance, receiving a phone call, the user’s navigating to another
     * activity, or the device screen’s turning off.  Be aware that the system calls this method every
     * time your activity comes into the foreground, including when it's created for the first time. As
     * such, you should implement onResume() to initialize components that you release during onPause(),
     * and perform any other initializations that must occur each time the activity enters the Resumed state.
     * For example, you should begin animations and initialize components that the activity only uses
     * when it has user focus.
     * ** Always call super() first.
     */
    @Override
    protected void onResume() {
        super.onResume();

        logAndAppend(ON_RESUME);
    }


    // TODOne (4) Override onPause, call super.onPause, and call logAndAppend with ON_PAUSE

    /**
     * ONPAUSE - Use the onPause() method to pause operations such animations and music playback that
     * should not continue while the Activity is in the Paused state, and that you expect to resume shortly.
     * There are several reasons why an activity may enter this state. For example:

     * Some event interrupts app execution, as described in the onResume() section. This is the most common case.
     * In Android 7.0 (API level 24) or higher, multiple apps run in multi-window mode. Because only one of the
     * apps (windows) has focus at any time, the system pauses all of the other apps.
     * A new, semi-transparent activity (such as a dialog) opens. As long as the activity is still partially visible
     * but not in focus, it remains paused.
     * You can use the onPause() method to release system resources, such as broadcast receivers, handles to sensors
     * (like GPS), or any resources that may affect battery life while your activity is paused and the user does not need them.

     * onPause() execution is very brief, and does not necessarily afford enough time to perform save operations.
     * For this reason, you should not use onPause() to save application or user data, make network calls, or execute
     * database transactions; such work may not complete before the method completes. Instead, you should perform heavy-load
     * shutdown operations during onStop().
     ** Always call super() first.
     */
    @Override
    protected void onPause() {
        super.onPause();

        logAndAppend(ON_PAUSE);
    }


    // TODOne (5) Override onStop, call super.onStop, and call logAndAppend with ON_STOP
    /**
     * ONSTOP - In the onStop() method, the app should release almost all resources that aren't
     * needed while the user is not using it. For example, if you registered a BroadcastReceiver in
     * onStart() to listen for changes that might affect your UI, you can unregister the broadcast
     * receiver in onStop(), as the user can no longer see the UI. It is also important that you use
     * onStop() to release resources that might leak memory, because it is possible for the system to
     * kill the process hosting your activity without calling the activity's final onDestroy() callback.
     *
     * You should also use onStop() to perform relatively CPU-intensive shutdown operations. For example,
     * if you can't find a more opportune time to save information to a database, you might do so during onStop().
     *
     * When your activity enters the Stopped state, the Activity object is kept resident in memory: It
     * maintains all state and member information, but is not attached to the window manager. When the
     * activity resumes, the activity recalls this information. You don’t need to re-initialize components
     * that were created during any of the callback methods leading up to the Resumed state. The system also
     * keeps track of the current state for each View object in the layout, so if the user entered text into an
     * EditText widget, that content is retained so you don't need to save and restore it.
     */
    @Override
    protected void onStop() {
        super.onStop();

        logAndAppend(ON_STOP);
    }

    // TODOne (6) Override onRestart, call super.onRestart, and call logAndAppend with ON_RESTART
    /**
     * ONRESTART - Called after onStop() when the current activity is being re-displayed to the user
     * (the user has navigated back to it). It will be followed by onStart() and then onResume().
     *
     * For activities that are using raw Cursor objects (instead of creating them through
     * managedQuery(android.net.Uri, String[], String, String[], String), this is usually the place
     * where the cursor should be requeried (because you had deactivated it in onStop().
     */
    @Override
    protected void onRestart() {
        super.onRestart();

        logAndAppend(ON_RESTART);
    }

    // TODOne (7) Override onDestroy, call super.onDestroy, and call logAndAppend with ON_DESTROY
    /**
     * The final call you receive before your activity is destroyed. This can happen either because
     * the activity is finishing (someone called finish() on it, or because the system is
     * temporarily destroying this instance of the activity to save space. You can distinguish
     * between these two scenarios with the isFinishing() method.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();

        logAndAppend(ON_DESTROY);
    }

    /**
     * Logs to the console and appends the lifecycle method name to the TextView so that you can
     * view the series of method callbacks that are called both from the app and from within
     * Android Studio's Logcat.
     *
     * @param lifecycleEvent The name of the event to be logged.
     */
    private void logAndAppend(String lifecycleEvent) {
        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);

        mLifecycleDisplay.append(lifecycleEvent + "\n");
    }

    /**
     * This method resets the contents of the TextView to its default text of "Lifecycle callbacks"
     *
     * @param view The View that was clicked. In this case, it is the Button from our layout.
     */
    public void resetLifecycleDisplay(View view) {
        mLifecycleDisplay.setText("Lifecycle callbacks:\n");
    }
}
