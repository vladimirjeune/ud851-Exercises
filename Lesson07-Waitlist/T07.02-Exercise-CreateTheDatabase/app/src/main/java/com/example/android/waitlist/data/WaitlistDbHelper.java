package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.android.waitlist.data.WaitlistContract.*;

// TODOne (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_WAITLIST_TABLE =
            "CREATE TABLE " +
                    WaitlistEntry.TABLE_NAME + " (" +
                    // AUTOINCREMENT will put a value in for you
                    WaitlistEntry._ID               + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    WaitlistEntry.COLUMN_GUEST_NAME + " TEXT NOT NULL, " +
                    WaitlistEntry.COLUMN_PARTY_SIZE + " INTEGER NOT NULL, " +

                    // With DEFAULT as TimeStamp; SQL will put a timestamp in for you
                    WaitlistEntry.COLUMN_TIMESTAMP  + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                    ")";

    private static final String SQL_DELETE_WAITLIST_TABLE =
            "DROP TABLE IF EXISTS " +
                    WaitlistEntry.TABLE_NAME;

    // TODOne (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"
    private static final String DATABASE_NAME = "waitlist.db";

    // TODOne (3) Create a static final String called DATABASE_VERSION and set it to 1.
    // If you change the schema you must monotonically increase the version.
    private static final int DATABASE_VERSION = 1;

    // TODOne (4) Create a Constructor that takes a context and calls the parent constructor
    public WaitlistDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  // We are not using the 3rd param
    }

    // TODOne (5) Override the onCreate method
    // TODOne (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table
    // TODOne (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }


    // TODOne (8) Override the onUpgrade method
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // TODOne (9) Inside, execute a drop table query, and then call onCreate to re-create it
        sqLiteDatabase.execSQL(SQL_DELETE_WAITLIST_TABLE);
        onCreate(sqLiteDatabase);

    }

}