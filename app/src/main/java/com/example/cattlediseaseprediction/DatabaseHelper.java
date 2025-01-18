package com.example.cattlediseaseprediction;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Information
    private static final String DATABASE_NAME = "userDB";
    private static final int DATABASE_VERSION = 2;  // Incremented version

    // Table and column names
    public static final String TABLE_USER = "user";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_PHONE = "phone";  // Add phone column

    // SQL query to create table with phone column
    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + " (" +
            COLUMN_EMAIL + " TEXT PRIMARY KEY, " +
            COLUMN_PASSWORD + " TEXT, " +
            COLUMN_PHONE + " TEXT);";  // Add phone column to table

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // OnCreate method to create the table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
    }

    // OnUpgrade method to upgrade the database (adding the 'phone' column)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            // Add COLUMN_PHONE if upgrading to version 2
            db.execSQL("ALTER TABLE " + TABLE_USER + " ADD COLUMN " + COLUMN_PHONE + " TEXT");
        }
    }
}

