package com.hean.sqlitecrud.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "User.db";
    public static final int DB_VERSION = 1;

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public DBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String USER_TABLE = "CREATE TABLE " + User.UserDetails.TABLE_NAME + " ( " +
                User.UserDetails.COL_ID + " INTEGER PRIMARY KEY," +
                User.UserDetails.COL_NAME + " TEXT," +
                User.UserDetails.COL_EMAIL + " TEXT," +
                User.UserDetails.COL_PHONE + " TEXT)";
        db.execSQL(USER_TABLE);
    }

    //------------------------------Insert------------------------------------
    public boolean addUser(int id, String name, String email, String phone) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(User.UserDetails.COL_ID, id);
        values.put(User.UserDetails.COL_NAME, name);
        values.put(User.UserDetails.COL_EMAIL, email);
        values.put(User.UserDetails.COL_PHONE, phone);

        long sid = db.insert(User.UserDetails.TABLE_NAME, null, values);
        if (sid > 0) {
            return true;
        } else {
            return false;

        }
    }

    //------------------------------Update------------------------------------
    public boolean updateUser(int id, String name, String email, String phone) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.UserDetails.COL_NAME, name);
        values.put(User.UserDetails.COL_EMAIL, email);
        values.put(User.UserDetails.COL_PHONE, phone);

        long sid = db.update(User.UserDetails.TABLE_NAME, values,
                User.UserDetails.COL_ID + " = ? ",
                new String[]{String.valueOf(id)});


        if (sid > 0) {
            return true;
        } else {
            return false;
        }
    }

    //------------------------------Delete------------------------------------
    public boolean deleteUser(int id) {
        SQLiteDatabase db = getWritableDatabase();
        long sid = db.delete(User.UserDetails.TABLE_NAME, User.UserDetails.COL_ID + " = ? ",
                new String[]{String.valueOf(id)});
        if (sid > 0) {
            return true;
        } else {
            return false;
        }
    }

    //------------------------------ViewDATA------------------------------------
    //Query only name to ListView
    public ArrayList<User> getUsers() {
        ArrayList<User> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        /*
        Cursor cursor = db.query(User.UserDetails.TABLE_NAME,
                new String[]{User.UserDetails.COL_NAME}, null, null, null, null, null);
                */
        String[] projection = {
                User.UserDetails.COL_ID,
                User.UserDetails.COL_NAME,
                User.UserDetails.COL_EMAIL,
                User.UserDetails.COL_PHONE
        };
        Cursor cursor;
        try
        {
            cursor = db.query(
                    User.UserDetails.TABLE_NAME,   // The table to query
                    projection,             // The array of columns to return (pass null to get all)
                    null,              // The columns for the WHERE clause
                    null,          // The values for the WHERE clause
                    null,                   // don't group the rows
                    null,                   // don't filter by row groups
                    User.UserDetails.COL_NAME + " DESC"               // The sort order
            );
            list = new ArrayList<>();
            while (cursor.moveToNext()) {
                User newUser = new User(
                        cursor.getInt(cursor.getColumnIndex(User.UserDetails.COL_ID)),
                        cursor.getString(cursor.getColumnIndex(User.UserDetails.COL_NAME)),
                        cursor.getString(cursor.getColumnIndex(User.UserDetails.COL_EMAIL)),
                        cursor.getString(cursor.getColumnIndex(User.UserDetails.COL_PHONE))
                );
                list.add(newUser);
            }
            cursor.close();
        }catch (Exception e) {
            System.out.println("haha");
        }


        return list;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
