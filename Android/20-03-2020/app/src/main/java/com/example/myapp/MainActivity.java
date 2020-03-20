package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapp.db.sqlite.Database;

public class MainActivity extends AppCompatActivity {
    //This is an example of SQLite
    //sqlite = local database, save your date in your app
    //but donot save too much, only for caching
    //sqlite db has 1 file: db.sqlite
    //many SQL commands can be used, but INNER JOIN
    //donot have procedures, funtions, trigger....
    //For example, we have a table named Plant, to detail plant
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //manual test, UI later
        Database database = new Database(this);
        //database.insertPlant("tomato", "This is a tomato");
        //get allplant so see ?
        database.getAllPlants();
    }
}
