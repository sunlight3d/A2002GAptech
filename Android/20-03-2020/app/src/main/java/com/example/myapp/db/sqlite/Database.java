package com.example.myapp.db.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Database {
    private static final String TAG = "SQLite";
    private Context context;
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    public Database(Context context) {
        //context = activity = screen to call this object
        this.context = context;
        this.dbHelper = new DBHelper(context);
    }
    public void insertPlant(String name, String description) {
        this.db = dbHelper.getWritableDatabase();
        ContentValues newPlant = new ContentValues();
        newPlant.put(PlantEntry.COLUMN_NAME, name);
        newPlant.put(PlantEntry.COLUMN_DESCRIPTION, description);
        long newRowId = db.insert(PlantEntry.TABLE_NAME, null, newPlant);
        System.out.println("Haha");
    }
    public void deletePlant(Integer id) {
        String selection = PlantEntry._ID + " == ?";//This prevent "SQL Injection"
        String[] selectionArgs = { String.valueOf(id) };
        int deletedRows = db.delete(PlantEntry.TABLE_NAME,
                selection, selectionArgs);
    }
    public void updatePlant(Hashtable<String, String> updatedPlant) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PlantEntry.COLUMN_NAME, updatedPlant.get("name"));
        values.put(PlantEntry.COLUMN_DESCRIPTION, updatedPlant.get("description"));

        String selection = PlantEntry._ID + " == ?";
        String[] selectionArgs = { updatedPlant.get("id") };
        int count = db.update(
                PlantEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        Log.d("SQLite", "There are "+count+"items has been updated");
    }

    public ArrayList<Hashtable<String, String>> getAllPlants() {
        //display all plants in your local db
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columns = {
                BaseColumns._ID,
                PlantEntry.COLUMN_NAME,
                PlantEntry.COLUMN_DESCRIPTION
        };
        String sortOrder =
                PlantEntry.COLUMN_NAME + " ASC";

        Cursor cursor = db.query(
                PlantEntry.TABLE_NAME,   // The table to query
                columns,
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
        ArrayList<Hashtable<String, String>> plants = new ArrayList<>();
        while(cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(PlantEntry._ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(PlantEntry.COLUMN_NAME));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(PlantEntry.COLUMN_DESCRIPTION));
            Hashtable<String, String> newObject = new Hashtable<>();
            newObject.put("id", String.valueOf(id));
            newObject.put("name", name);
            newObject.put("description", description);
            plants.add(newObject);
        }
        cursor.close();
        return plants;
    }
}

