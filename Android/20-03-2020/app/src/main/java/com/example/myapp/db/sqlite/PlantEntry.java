package com.example.myapp.db.sqlite;

import android.provider.BaseColumns;

public class PlantEntry implements BaseColumns {
    //This is a class which is mapped to a Table in Database
    public static final String TABLE_NAME = "tlbPlants";
    //Some column
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";

}
