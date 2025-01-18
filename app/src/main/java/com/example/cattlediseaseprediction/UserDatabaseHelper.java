package com.example.cattlediseaseprediction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserDatabaseHelper {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public UserDatabaseHelper(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Open the database
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    // Close the database
    public void close() {
        dbHelper.close();
    }

    public boolean insertUser(String email, String password, String phone) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_EMAIL, email);
        values.put(DatabaseHelper.COLUMN_PASSWORD, password);
        values.put(DatabaseHelper.COLUMN_PHONE, phone);  // Store phone number

        // Insert the user into the table
        long result = database.insert(DatabaseHelper.TABLE_USER, null, values);
        return result != -1;
    }

    // Validate user credentials (for sign-in)
    public boolean validateUser(String email, String password) {
        Cursor cursor = database.query(DatabaseHelper.TABLE_USER,
                new String[]{DatabaseHelper.COLUMN_EMAIL, DatabaseHelper.COLUMN_PASSWORD},
                DatabaseHelper.COLUMN_EMAIL + "=? AND " + DatabaseHelper.COLUMN_PASSWORD + "=?",
                new String[]{email, password}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            cursor.close();
            return true;  // User found
        } else {
            return false;  // User not found
        }
    }


    public boolean isEmailRegistered(String email) {
        Cursor cursor = database.query(DatabaseHelper.TABLE_USER,
                new String[]{DatabaseHelper.COLUMN_EMAIL},
                DatabaseHelper.COLUMN_EMAIL + "=?",
                new String[]{email}, null, null, null);

        boolean exists = (cursor != null && cursor.moveToFirst());
        if (cursor != null) {
            cursor.close();
        }
        return exists;
    }
}

