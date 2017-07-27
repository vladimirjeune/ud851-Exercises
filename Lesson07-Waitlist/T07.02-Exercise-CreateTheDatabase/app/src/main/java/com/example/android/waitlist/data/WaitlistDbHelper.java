package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.waitlist.data.WaitlistContract.*;

// TODO (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {

    // TODO (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"
    private static final String DATABASE_NAME = "waitelist.db";

    // TODO (3) Create a static final String called DATABASE_VERSION and set it to 1
    private static final int DATABASE_VERSION = 1;

    // TODO (4) Create a Constructor that takes a context and calls the parent constructor
    public WaitlistDbHelper(Context context) {

    }


    // TODO (5) Override the onCreate method

    // TODO (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table

    // TODO (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }


    // TODO (8) Override the onUpgrade method
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // TODO (9) Inside, execute a drop table query, and then call onCreate to re-create it

    }








}